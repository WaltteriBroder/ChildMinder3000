package fi.aldowaldo.childminder.service;

import fi.aldowaldo.childminder.dto.TeacherChildgroupDto;
import fi.aldowaldo.childminder.model.Child;
import fi.aldowaldo.childminder.model.Teacher;
import fi.aldowaldo.childminder.repository.ChildRepository;
import fi.aldowaldo.childminder.repository.ChildScheduleRepository;
import fi.aldowaldo.childminder.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final ChildRepository childRepository;
    private final ChildScheduleRepository childScheduleRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, ChildRepository childRepository, ChildScheduleRepository childScheduleRepository) {
        this.teacherRepository = teacherRepository;
        this.childRepository = childRepository;
        this.childScheduleRepository = childScheduleRepository;
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Iterable<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public List<Child> getTeachersChildren(Long teacherId) {
        return childRepository.getTeachersChildren(teacherId);
    }

    public List<Optional<Child>> getTeachersChildrenForTheDay(Long teacherId, String dateAsString) {

        LocalDate date = LocalDate.parse(dateAsString);
        List<Child> teachersChildren = childRepository.getTeachersChildren(teacherId);
        return  getChildrenForDate(teachersChildren, date);
    }

    private List<Optional<Child>> getChildrenForDate(List<Child> children, LocalDate date) {

        List<Optional<Child>> childrenForTheDay = new ArrayList<>();

        for(Child child : children){

            Long childId = childScheduleRepository.getChildIdOnDate(child.getId(), date);
            if(childId != null){
                Optional<Child> childById = childRepository.findById(childId);
                childrenForTheDay.add(childById);
            }
        }
        return childrenForTheDay;
    }

    public void removeTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    @Transactional
    public void assignAGroup(TeacherChildgroupDto dto) {
        teacherRepository.assignAGroup(dto.getTeacherId(), dto.getGroupId());
    }

    @Transactional
    public void unassignAGroup(TeacherChildgroupDto dto) {
        teacherRepository.unassignAGroup(dto.getTeacherId(), dto.getGroupId());
    }
}
