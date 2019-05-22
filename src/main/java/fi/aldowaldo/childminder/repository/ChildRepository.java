package fi.aldowaldo.childminder.repository;

import fi.aldowaldo.childminder.model.Child;
import org.springframework.data.repository.CrudRepository;

public interface ChildRepository extends CrudRepository<Child, Long> {
}
