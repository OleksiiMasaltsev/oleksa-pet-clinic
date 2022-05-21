package ua.masaltsev.petclinic.services;

import ua.masaltsev.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
