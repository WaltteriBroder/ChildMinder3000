package fi.aldowaldo.childminder.controller;

import fi.aldowaldo.childminder.dto.AssignChildGroupToTeacherDto;
import fi.aldowaldo.childminder.model.Teacher;
import fi.aldowaldo.childminder.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/")
    public void addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
    }

    @PostMapping("/assign")
    public void assignAGroup(@RequestBody AssignChildGroupToTeacherDto dto){
        teacherService.assignAGroup(dto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void removeTeacher(@PathVariable(value = "id") Long id) {
        teacherService.removeTeacher(id);
    }

}
