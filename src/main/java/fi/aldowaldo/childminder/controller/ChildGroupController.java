package fi.aldowaldo.childminder.controller;


import fi.aldowaldo.childminder.dto.AddChildToChildGroupDto;
import fi.aldowaldo.childminder.model.Childgroup;
import fi.aldowaldo.childminder.service.ChildGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/childgroup")
public class ChildGroupController {

    private final ChildGroupService childGroupService;

    @Autowired
    public ChildGroupController(ChildGroupService childGroupService) {
        this.childGroupService = childGroupService;
    }

    @PostMapping("/add")
    public void addChildGroup(@RequestBody Childgroup childgroup){
        childGroupService.addChildGroup(childgroup);
    }

    @GetMapping("/all")
    public Iterable<Childgroup> getAllChildGroups(){
        return childGroupService.getAllChildGroups();
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteChildGroup(@PathVariable(value = "id") Long id) {
        childGroupService.deleteChildGroup(id);
    }

    @PostMapping("/addchild")
    public void addChildToChildGroup(@RequestBody AddChildToChildGroupDto dto){
        childGroupService.addChildToChildGroup(dto);
    }
}
