package fi.aldowaldo.childminder.repository;

import fi.aldowaldo.childminder.model.Childgroup;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ChildGroupRepository extends CrudRepository<Childgroup, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE child SET childgroup_id =? WHERE child_id = ?", nativeQuery = true)
    void addChildToChildGroup(Long groupId, Long childId);



}


