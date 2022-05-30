package ua.masaltsev.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.masaltsev.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
