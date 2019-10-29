package fi.aldowaldo.childminder.controller;

import fi.aldowaldo.childminder.dto.TeacherChildgroupDto;
import fi.aldowaldo.childminder.model.Child;
import fi.aldowaldo.childminder.model.Teacher;
import fi.aldowaldo.childminder.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/add")
    public void addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
    }

    @GetMapping("/all")
    public Iterable<Teacher> getAllTeachers(){
       return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}/children")
    public List<Child> getTeachersChildren(@PathVariable(value = "id") Long teacherId){
        return teacherService.getTeachersChildren(teacherId);
    }

    @GetMapping("/{id}/children/{date}")
    public List<Optional<Child>> getTeachersChildrenForTheDay(@PathVariable(value = "id") Long teacherId, @PathVariable(value = "date") String date){
        return teacherService.getTeachersChildrenForTheDay(teacherId, date);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void removeTeacher(@PathVariable(value = "id") Long id) {
        teacherService.removeTeacher(id);
    }

    @PostMapping("/assign")
    public void assignAGroup(@RequestBody TeacherChildgroupDto dto){
        teacherService.assignAGroup(dto);
    }

    @DeleteMapping("/unassign")
    public void unassignAGroup(@RequestBody TeacherChildgroupDto dto){
        teacherService.unassignAGroup(dto);
    }

}
