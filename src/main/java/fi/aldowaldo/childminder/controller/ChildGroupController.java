package fi.aldowaldo.childminder.controller;


import fi.aldowaldo.childminder.dto.AddChildToChildGroupDto;
import fi.aldowaldo.childminder.model.ChildGroup;
import fi.aldowaldo.childminder.service.ChildGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/childgroup")
public class ChildGroupController {

    private final ChildGroupService childGroupService;

    @Autowired
    public ChildGroupController(ChildGroupService childGroupService) {
        this.childGroupService = childGroupService;
    }

    @PostMapping("/")
    public void addChildGroup(@RequestBody ChildGroup childGroup){
        childGroupService.addChildGroup(childGroup);
    }

    @PostMapping("/addchild")
    public void addChildToChildGroup(@RequestBody AddChildToChildGroupDto dto){
        childGroupService.addChildToChildGroup(dto);
    }
}
