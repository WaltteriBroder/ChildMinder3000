package fi.aldowaldo.childminder.service;

import fi.aldowaldo.childminder.dto.ChildAndChildGroupDto;
import fi.aldowaldo.childminder.model.Childgroup;
import fi.aldowaldo.childminder.repository.ChildGroupRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class ChildgroupServiceTest {

    @InjectMocks
    ChildGroupService childGroupService;

    @Mock
    ChildGroupRepository childGroupRepository;

    @Test
    public void addChildGroup(){
        Childgroup childgroup = new Childgroup();
        childGroupService.addChildGroup(childgroup);
        verify(childGroupRepository, times(1)).save(childgroup);
    }

    @Test
    public void getAllChildGroups(){
        childGroupService.getAllChildGroups();
        verify(childGroupRepository, times(1)).findAll();
    }

    @Test
    public void deleteChildGroup(){
        childGroupService.deleteChildGroup(1l);
        verify(childGroupRepository, times(1)).deleteById(1l);
    }

    @Test
    public void addChildToChildGroup(){
        ChildAndChildGroupDto dto = new ChildAndChildGroupDto(1l,2l);
        childGroupService.addChildToChildGroup(dto);
        verify(childGroupRepository, times(1)).addChildToChildGroup(dto.getGroupId(), dto.getChildId());
    }
}
