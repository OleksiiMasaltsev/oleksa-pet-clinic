package ua.masaltsev.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.masaltsev.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
