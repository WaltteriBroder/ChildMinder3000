package fi.aldowaldo.childminder.service;

import fi.aldowaldo.childminder.dto.ChildAndChildGroupDto;
import fi.aldowaldo.childminder.model.Childgroup;
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

    public void addChildGroup(Childgroup childgroup){
        childGroupRepository.save(childgroup);
    }

    public Iterable<Childgroup> getAllChildGroups() {
        return childGroupRepository.findAll();
    }

    public void deleteChildGroup(Long id) {
        childGroupRepository.deleteById(id);
    }

    @Transactional
    public void addChildToChildGroup(ChildAndChildGroupDto dto) {
        childGroupRepository.addChildToChildGroup(dto.getGroupId(), dto.getChildId());
    }

    @Transactional
    public void removeChildFromChildGroup(Long childId) {
        childGroupRepository.removeChildFromChildGroup(childId);
    }
}
