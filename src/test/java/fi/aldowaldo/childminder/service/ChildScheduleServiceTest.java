package fi.aldowaldo.childminder.service;

import fi.aldowaldo.childminder.model.ChildSchedule;
import fi.aldowaldo.childminder.repository.ChildScheduleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class ChildScheduleServiceTest {

    @InjectMocks
    ChildScheduleService childScheduleService;

    @Mock
    ChildScheduleRepository childScheduleRepository;

    @Test
    public void addChildGroup(){
        ChildSchedule childSchedule = new ChildSchedule();
        childScheduleService.addSchedule(childSchedule);
        verify(childScheduleRepository, times(1)).save(childSchedule);
    }

    @Test
    public void addSchduleForManyDays(){

        ChildSchedule childSchedule = new ChildSchedule();
        List<ChildSchedule> scheduleList = Arrays.asList(childSchedule);
        childScheduleService.addSchduleForManyDays(scheduleList);
        verify(childScheduleRepository, times(1)).saveAll(scheduleList);
    }

    @Test
    public void removeSchedule(){
        childScheduleService.removeSchedule(1l);
        verify(childScheduleRepository, times(1)).deleteById(1l);
    }
}
