package fi.aldowaldo.childminder.repository;

import fi.aldowaldo.childminder.model.ChildGroup;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ChildGroupRepository extends CrudRepository<ChildGroup, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE childminder.child SET child_group_id =? WHERE child_id = ?", nativeQuery = true)
    void addChildToChildGroup(Long groupId, Long childId);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE childminder.child_group SET name =? WHERE child_group_id = ?", nativeQuery = true)
    void editGroupName(String newGroupName, Long id);


    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE childminder.child SET child_group_id = NULL WHERE child_id = ?", nativeQuery = true)
    void removeChildFromChildGroup(Long childId);

}


