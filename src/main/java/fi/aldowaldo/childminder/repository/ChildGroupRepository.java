package fi.aldowaldo.childminder.repository;

import fi.aldowaldo.childminder.model.Childgroup;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ChildGroupRepository extends CrudRepository<Childgroup, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE childminder.child SET childgroup_id =? WHERE child_id = ?", nativeQuery = true)
    void addChildToChildGroup(Long groupId, Long childId);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE childminder.childgroup SET name =? WHERE childgroup_id = ?", nativeQuery = true)
    void editGroupName(String newGroupName, Long id);


    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE childminder.child SET childgroup_id = NULL WHERE child_id = ?", nativeQuery = true)
    void removeChildFromChildGroup(Long childId);

}


