package fi.aldowaldo.childminder.service;

import fi.aldowaldo.childminder.dto.ChildArrivalDto;
import fi.aldowaldo.childminder.model.Child;
import fi.aldowaldo.childminder.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

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
        return childRepository.findAll();
    }

    public Optional<Child> getChild(Long id) {
        return childRepository.findById(id);
    }

    public Iterable<Child> getAllPresentChildren() {
        return childRepository.getAllPresentChildren();
    }

    public Iterable<ChildArrivalDto> getAllChildrenForTheDay(String dateAsString) {
        LocalDate date = LocalDate.parse(dateAsString);
        return childRepository.getAllChildrenForTheDay(date);
    }

    public Iterable<ChildArrivalDto> getAllChildrenForToday() {
        LocalDate date = LocalDate.now();
        return childRepository.getAllChildrenForTheDay(date);
    }

    public void editChild(Child editedChild) {

        Child child = childRepository.findById(editedChild.getId()).get();

        child.setFirstName(editedChild.getFirstName());
        child.setBirthday(editedChild.getBirthday());
        child.setChildGroup(editedChild.getChildGroup());
        child.setPresent(editedChild.isPresent());

        childRepository.save(child);
    }

    public void removeChild(Long id) {
        childRepository.deleteById(id);
    }
}
