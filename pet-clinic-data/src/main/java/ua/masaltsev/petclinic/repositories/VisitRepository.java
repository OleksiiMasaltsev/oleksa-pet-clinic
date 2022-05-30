package ua.masaltsev.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.masaltsev.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
