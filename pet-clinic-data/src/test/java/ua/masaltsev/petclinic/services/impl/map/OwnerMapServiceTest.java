package ua.masaltsev.petclinic.services.impl.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.masaltsev.petclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        Owner owner1 = Owner.builder().city("Kyiv").address("Khreschatyk, 44").build();
        owner1.setId(1L);
        Owner owner2 = Owner.builder().city("Odesa").address("Deribasivska, 15").build();
        owner2.setId(2L);
        ownerMapService.save(owner1);
        ownerMapService.save(owner2);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        assertEquals(1L, ownerMapService.findById(1L).getId());
        assertEquals(2L, ownerMapService.findById(2L).getId());
    }
}