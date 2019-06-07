package fi.aldowaldo.childminder.controller;

import fi.aldowaldo.childminder.dto.ChildArrivalDto;
import fi.aldowaldo.childminder.model.ChildSchedule;
import fi.aldowaldo.childminder.service.ChildScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ChildScheduleContoller {

    private final ChildScheduleService childScheduleService;

    public ChildScheduleContoller(ChildScheduleService childScheduleService) {
        this.childScheduleService = childScheduleService;
    }

    @PostMapping("/add")
    public void addSchedule(@RequestBody ChildSchedule childSchedule){
        childScheduleService.addSchedule(childSchedule);
    }

    @PostMapping("/add/many")
    public void addSchduleForManyDays(@RequestBody List<ChildSchedule> childSchedules){
        childScheduleService.addSchduleForManyDays(childSchedules);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void removeSchedule(@PathVariable(value = "id") Long id) {
        childScheduleService.removeSchedule(id);
    }

}
