package ua.masaltsev.petclinic.services.impl;

import ua.masaltsev.petclinic.model.Visit;
import ua.masaltsev.petclinic.repositories.VisitRepository;
import ua.masaltsev.petclinic.services.VisitService;

import java.util.HashSet;
import java.util.Set;

public class VisitServiceJpa implements VisitService {

    private final VisitRepository visitRepository;

    VisitServiceJpa(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
