package fi.aldowaldo.childminder.repository;

import fi.aldowaldo.childminder.model.ChildSchedule;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChildScheduleRepository extends JpaRepository<ChildSchedule, Long> {
}
