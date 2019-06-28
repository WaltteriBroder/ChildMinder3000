package fi.aldowaldo.childminder.service;

import fi.aldowaldo.childminder.dto.TeacherChildgroupDto;
import fi.aldowaldo.childminder.model.Teacher;
import fi.aldowaldo.childminder.repository.ChildRepository;
import fi.aldowaldo.childminder.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class TeacherServiceTest {

    @InjectMocks
    TeacherService teacherService;

    @Mock
    TeacherRepository teacherRepository;

    @Mock
    ChildRepository childRepository;

    @Test
    public void addTeacher(){
        Teacher teacher = new Teacher();
        teacherService.addTeacher(teacher);
        verify(teacherRepository, times(1)).save(teacher);
    }

    @Test
    public void getAllTeachers(){
        teacherService.getAllTeachers();
        verify(teacherRepository, times(1)).findAll();
    }

    @Test
    public void getTeachersChildren(){
        teacherService.getTeachersChildren(1l);
        verify(childRepository, times(1)).getTeachersChildren(1l);
    }

    @Test
    public void removeTeacher(){
        teacherService.removeTeacher(1l);
        verify(teacherRepository, times(1)).deleteById(1l);
    }

    @Test
    public void assignAGroup(){
        TeacherChildgroupDto dto = new TeacherChildgroupDto(1l,2l);
        teacherService.assignAGroup(dto);
        verify(teacherRepository, times(1)).assignAGroup(dto.getTeacherId(), dto.getGroupId());
    }
}
