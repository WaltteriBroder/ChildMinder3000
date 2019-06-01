package fi.aldowaldo.childminder.service;

import fi.aldowaldo.childminder.dto.AddChildToChildGroupDto;
import fi.aldowaldo.childminder.model.ChildGroup;
import fi.aldowaldo.childminder.repository.ChildGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChildGroupService {

    private final ChildGroupRepository childGroupRepository;

    @Autowired
    public ChildGroupService(ChildGroupRepository childGroupRepository) {
        this.childGroupRepository = childGroupRepository;
    }

    public void addChildGroup(ChildGroup childGroup){
        childGroupRepository.save(childGroup);
    }


    public void deleteChildGroup(Long id) {
        childGroupRepository.deleteById(id);
    }

    @Transactional
    public void addChildToChildGroup(AddChildToChildGroupDto dto) {
        childGroupRepository.addChildToChildGroup(dto.getGroupId(), dto.getChildId());
    }
}
