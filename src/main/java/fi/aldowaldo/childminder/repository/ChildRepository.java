package fi.aldowaldo.childminder.repository;

import fi.aldowaldo.childminder.dto.ChildArrivalDto;
import fi.aldowaldo.childminder.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long> {

    @Query(value = "SELECT child.child_id, child.birthday, child.first_name, child.childgroup_id, child.present FROM childminder.child " +
            "LEFT JOIN childminder.teacher_childgroup on child.childgroup_id = teacher_childgroup.childgroup_id " +
            "LEFT JOIN childminder.teacher ON teacher.teacher_id = teacher_childgroup.teacher_id " +
            "WHERE teacher.teacher_id = ?1",
            nativeQuery = true)
    List<Child> getTeachersChildren(Long teacherId);


    @Query(value = "SELECT * FROM child WHERE present = true",
            nativeQuery = true)
    Iterable<Child> getAllPresentChildren();


    @Query("SELECT NEW fi.aldowaldo.childminder.dto.ChildArrivalDto(c.id, c.first_name, c.present, cs.arrive, cs.departure, cg.id, cg.name)" +
            " FROM ChildSchedule cs INNER JOIN cs.child c INNER JOIN c.childgroup cg WHERE cs.scheduledate = :#{#scheduledate}")
    Iterable<ChildArrivalDto> getAllChildrenForTheDay(@Param("scheduledate") LocalDate scheduledate);
}
