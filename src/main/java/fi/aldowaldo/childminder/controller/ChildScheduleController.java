package fi.aldowaldo.childminder.controller;

import fi.aldowaldo.childminder.model.ChildSchedule;
import fi.aldowaldo.childminder.service.ChildScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/schedule")
public class ChildScheduleController {

    private final ChildScheduleService childScheduleService;

    public ChildScheduleController(ChildScheduleService childScheduleService) {
        this.childScheduleService = childScheduleService;
    }

    @PostMapping("/add")
    public void addSchedule(@RequestBody ChildSchedule childSchedule) {
        childScheduleService.addSchedule(childSchedule);
    }

    @PostMapping("/add/many")
    public void addSchduleForManyDays(@RequestBody List<ChildSchedule> childSchedules) {
        childScheduleService.addSchduleForManyDays(childSchedules);
    }

    @DeleteMapping("/delete/{id}")
    public void removeSchedule(@PathVariable(value = "id") Long id) {
        childScheduleService.removeSchedule(id);
    }

    @GetMapping("/child/{childId}")
    public List<ChildSchedule> getSchedulesForChild(@PathVariable(value = "childId") Long childId) {
        return childScheduleService.getSchedulesForChild(childId);
    }
}
