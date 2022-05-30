package ua.masaltsev.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.masaltsev.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
