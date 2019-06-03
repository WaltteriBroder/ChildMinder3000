package fi.aldowaldo.childminder.repository;

import fi.aldowaldo.childminder.model.Child;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChildRepository extends CrudRepository<Child, Long> {

    @Query(value = "SELECT child.child_id, child.birthday, child.first_name, child.childgroup_id, child.present FROM child " +
            "LEFT JOIN teacher_childgroup on child.childgroup_id = teacher_childgroup.childgroup_id " +
            "LEFT JOIN teacher ON teacher.teacher_id = teacher_childgroup.teacher_id " +
            "WHERE teacher.teacher_id = ?1",
            nativeQuery = true)
    List<Child> getTeachersChildren(Long teacherId);
}
