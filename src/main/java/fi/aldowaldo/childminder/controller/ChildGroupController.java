package fi.aldowaldo.childminder.controller;


import fi.aldowaldo.childminder.dto.ChildAndChildGroupDto;
import fi.aldowaldo.childminder.model.ChildGroup;
import fi.aldowaldo.childminder.service.ChildGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/childgroup")
public class ChildGroupController {

    private final ChildGroupService childGroupService;

    @Autowired
    public ChildGroupController(ChildGroupService childGroupService) {
        this.childGroupService = childGroupService;
    }

    @PostMapping("/add")
    public void addChildGroup(@RequestBody ChildGroup childGroup){
        childGroupService.addChildGroup(childGroup);
    }

    @GetMapping("/all")
    public Iterable<ChildGroup> getAllChildGroups(){
        return childGroupService.getAllChildGroups();
    }

    @PutMapping("/edit/{id}")
    public void editGroupName(@PathVariable(value = "id") Long id, @RequestBody String newGroupName){
        childGroupService.editGroupName(id, newGroupName);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteChildGroup(@PathVariable(value = "id") Long id) {
        childGroupService.deleteChildGroup(id);
    }

    @PostMapping("/addchild")
    public void addChildToChildGroup(@RequestBody ChildAndChildGroupDto dto){
        childGroupService.addChildToChildGroup(dto);
    }

    @PostMapping("/removechild/{childId}")
    public void removeChildFromChildGroup(@PathVariable Long childId){
        childGroupService.removeChildFromChildGroup(childId);
    }
}
