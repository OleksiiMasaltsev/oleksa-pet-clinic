package ua.masaltsev.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.masaltsev.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
