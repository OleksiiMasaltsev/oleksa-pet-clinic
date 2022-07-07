package ua.masaltsev.petclinic.services;

import ua.masaltsev.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends AbstractService<Owner, Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
