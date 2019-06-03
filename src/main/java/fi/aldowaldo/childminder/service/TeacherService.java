package fi.aldowaldo.childminder.service;

import fi.aldowaldo.childminder.dto.AssignChildGroupToTeacherDto;
import fi.aldowaldo.childminder.model.Child;
import fi.aldowaldo.childminder.model.Teacher;
import fi.aldowaldo.childminder.repository.ChildRepository;
import fi.aldowaldo.childminder.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final ChildRepository childRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, ChildRepository childRepository) {
        this.teacherRepository = teacherRepository;
        this.childRepository = childRepository;
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

    public void removeTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    @Transactional
    public void assignAGroup(AssignChildGroupToTeacherDto dto) {
        teacherRepository.assignAGroup(dto.getTeacherId(), dto.getGroupId());
    }

}
