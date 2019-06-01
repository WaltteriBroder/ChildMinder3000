package fi.aldowaldo.childminder.repository;

import fi.aldowaldo.childminder.model.Teacher;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    @Modifying
    @Query(value = "INSERTO INTO teacher_childgroup (teacher_id, group_id) values (:teacherId, :groupId)",
            nativeQuery = true)
    void assignAGroup(@Param("teacherId") Long teacherId, @Param("groupId") Long groupId);

}
