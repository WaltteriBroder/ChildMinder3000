package fi.aldowaldo.childminder.service;

import fi.aldowaldo.childminder.model.Child;
import fi.aldowaldo.childminder.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildService {

    private final ChildRepository childRepository;

    @Autowired
    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    public void addChild(Child child){
        childRepository.save(child);
    }

    public Iterable<Child> getAllChilder() {
        return childRepository.findAll();
    }

    public void removeChild(Long id) {
        childRepository.deleteById(id);
    }
}
