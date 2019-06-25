package fi.aldowaldo.childminder.service;

import fi.aldowaldo.childminder.dto.ChildArrivalDto;
import fi.aldowaldo.childminder.model.Child;
import fi.aldowaldo.childminder.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

    public Iterable<Child> getAllChildren() {
        System.out.println("nakki!");
        return childRepository.findAll();
    }

    public Iterable<Child> getAllPresentChildren() {
        return childRepository.getAllPresentChildren();
    }

    public Iterable<ChildArrivalDto> getAllChildrenForTheDay(String dateAsString) {
        LocalDate date = LocalDate.parse(dateAsString);
        return childRepository.getAllChildrenForTheDay(date);
    }

    public void removeChild(Long id) {
        childRepository.deleteById(id);
    }
}
