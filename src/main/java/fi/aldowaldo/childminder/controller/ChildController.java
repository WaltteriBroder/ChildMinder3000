package fi.aldowaldo.childminder.controller;

import fi.aldowaldo.childminder.model.Child;
import fi.aldowaldo.childminder.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/child")
public class ChildController {

    private final ChildService childService;

    @Autowired
    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @PostMapping("/")
    public void addChild(@RequestBody Child child){
        childService.addChild(child);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void removeChild(@PathVariable(value = "id") Long id) {
        childService.removeChild(id);
    }

}
