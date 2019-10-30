package fi.aldowaldo.childminder.repository;

import fi.aldowaldo.childminder.model.Teacher;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    @Modifying
    @Query(value = "INSERT INTO childminder.teacher_child_group (teacher_id, child_group_id) values (:teacherId, :child_group_id)",
            nativeQuery = true)
    void assignAGroup(@Param("teacherId") Long teacherId, @Param("child_group_id") Long child_group_id);

    @Modifying
    @Query(value = "DELETE FROM childminder.teacher_child_group WHERE teacher_id =? AND child_group_id = ?",
            nativeQuery = true)
    void unassignAGroup(Long teacherId, Long childgroup_id);
}
