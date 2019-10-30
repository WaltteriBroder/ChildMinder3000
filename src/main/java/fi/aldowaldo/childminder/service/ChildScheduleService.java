package fi.aldowaldo.childminder.service;

import fi.aldowaldo.childminder.model.ChildSchedule;
import fi.aldowaldo.childminder.repository.ChildScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChildScheduleService {

    private final ChildScheduleRepository childScheduleRepository;

    public ChildScheduleService(ChildScheduleRepository childScheduleRepository) {
        this.childScheduleRepository = childScheduleRepository;
    }

    @Transactional
    public void addSchedule(ChildSchedule childSchedule) {

        Long childIdOnDate = childScheduleRepository.getChildIdOnDate(childSchedule.getChild().getId(), childSchedule.getDate());

        if(childIdOnDate == 0){
            childScheduleRepository.save(childSchedule);
        } else {
            childScheduleRepository.updateSchedule(childSchedule.getDate(), childSchedule.getArrive(), childSchedule.getDeparture(), childSchedule.getId());
        }
    }

    public void addSchduleForManyDays(List<ChildSchedule> childSchedules) {
        childScheduleRepository.saveAll(childSchedules);
    }

    public void removeSchedule(Long id) {
        childScheduleRepository.deleteById(id);
    }

    public List<ChildSchedule> getSchedulesForChild(Long childId) {
        return childScheduleRepository.getSchedulesForChild(childId);
    }
}
