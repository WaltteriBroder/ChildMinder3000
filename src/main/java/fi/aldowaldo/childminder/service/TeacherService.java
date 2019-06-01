package fi.aldowaldo.childminder.service;

import fi.aldowaldo.childminder.dto.AssignChildGroupToTeacherDto;
import fi.aldowaldo.childminder.model.Teacher;
import fi.aldowaldo.childminder.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Iterable<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void removeTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public void assignAGroup(AssignChildGroupToTeacherDto dto) {
        teacherRepository.assignAGroup(dto.getTeacherId(), dto.getGroupId());
    }

}
