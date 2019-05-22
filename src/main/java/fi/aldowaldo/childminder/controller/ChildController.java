package fi.aldowaldo.childminder.controller;

import fi.aldowaldo.childminder.model.Child;
import fi.aldowaldo.childminder.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
