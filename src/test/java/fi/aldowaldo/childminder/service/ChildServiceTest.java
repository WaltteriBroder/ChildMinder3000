package fi.aldowaldo.childminder.service;

import fi.aldowaldo.childminder.model.Child;
import fi.aldowaldo.childminder.repository.ChildRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class ChildServiceTest {

    @InjectMocks
    ChildService childService;

    @Mock
    ChildRepository childRepository;

    @Test
    public void addChild(){
        Child child = new Child();
        childService.addChild(child);
        verify(childRepository, times(1)).save(child);
    }

    @Test
    public void getAllChildren(){
        childService.getAllChildren();
        verify(childRepository, times(1)).findAll();
    }

    @Test
    public void getAllPresentChildren(){
        childService.getAllPresentChildren();
        verify(childRepository, times(1)).getAllPresentChildren();
    }

    @Test
    public void getAllChildrenForTheDay(){
        childService.getAllChildrenForTheDay("1990-07-07");
        verify(childRepository, times(1)).getAllChildrenForTheDay(any(LocalDate.class));
    }

    @Test
    public void removeChild(){
        childService.removeChild(1l);
        verify(childRepository, times(1)).deleteById(1l);
    }
}
