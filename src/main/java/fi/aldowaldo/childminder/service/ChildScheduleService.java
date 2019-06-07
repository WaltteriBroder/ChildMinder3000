package fi.aldowaldo.childminder.service;

import fi.aldowaldo.childminder.model.ChildSchedule;
import fi.aldowaldo.childminder.repository.ChildScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildScheduleService {

    private final ChildScheduleRepository childScheduleRepository;

    public ChildScheduleService(ChildScheduleRepository childScheduleRepository) {
        this.childScheduleRepository = childScheduleRepository;
    }

    public void addSchedule(ChildSchedule childSchedule) {
        childScheduleRepository.save(childSchedule);
    }

    public void addSchduleForManyDays(List<ChildSchedule> childSchedules) {
        childScheduleRepository.saveAll(childSchedules);
    }

    public void removeSchedule(Long id) {
        childScheduleRepository.deleteById(id);
    }

}
