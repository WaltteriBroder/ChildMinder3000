package fi.aldowaldo.childminder.controller;

import fi.aldowaldo.childminder.dto.ChildArrivalDto;
import fi.aldowaldo.childminder.model.Child;
import fi.aldowaldo.childminder.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/child")
public class ChildController {

    private final ChildService childService;

    @Autowired
    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @PostMapping("/add")
    public void addChild(@RequestBody Child child){
        childService.addChild(child);
    }

    @GetMapping("/all")
    public Iterable<Child> getAllChildren(){
        return childService.getAllChildren();
    }

    @GetMapping("/{id}")
    public Optional<Child> getChild(@PathVariable Long id){
        return childService.getChild(id);
    }

    @GetMapping("/all/present")
    public Iterable<Child> getAllPresentChildren(){
        return childService.getAllPresentChildren();
    }

    @GetMapping("/all/{date}")
    public Iterable<ChildArrivalDto> getAllChildrenForTheDay(@PathVariable String date){
        return childService.getAllChildrenForTheDay(date);
    }

    @GetMapping("/all/today")
    public Iterable<ChildArrivalDto> getAllChildrenForToday(){
        return childService.getAllChildrenForToday();
    }

    @PutMapping(value = "/edit")
    public void editChild( @RequestBody Child child) {
        childService.editChild(child);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void removeChild(@PathVariable(value = "id") Long id) {
        childService.removeChild(id);
    }

}
