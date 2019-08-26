package fi.aldowaldo.childminder.repository;

import fi.aldowaldo.childminder.model.ChildSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface ChildScheduleRepository extends JpaRepository<ChildSchedule, Long> {


    @Query(value = "SELECT child_id FROM childminder.child_schedule WHERE child_id =?1 AND date =?2 ",
            nativeQuery = true)
    Long getChildIdOnDate(Long childId, LocalDate date);


    @Query(value = "SELECT * FROM childminder.child_schedule WHERE child_id =?1 ",
            nativeQuery = true)
    List<ChildSchedule> getSchedulesForChild(Long childId);
}
