package ua.masaltsev.petclinic.services.impl;

import ua.masaltsev.petclinic.model.PetType;
import ua.masaltsev.petclinic.repositories.PetTypeRepository;
import ua.masaltsev.petclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

public class PetTypeServiceJpa implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    PetTypeServiceJpa(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
