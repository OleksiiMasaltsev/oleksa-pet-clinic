package ua.masaltsev.petclinic.services.impl.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.masaltsev.petclinic.model.Owner;
import ua.masaltsev.petclinic.repositories.OwnerRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

    Owner testOwner1;
    Owner testOwner2;
    Set<Owner> owners;

    static final String FIRST_NAME_1 = "Stepan";
    static final String LAST_NAME_1 = "Gryshko";
    static final long ID_1 = 1L;

    static final String FIRST_NAME_2 = "Olga";
    static final String LAST_NAME_2 = "Kruchko";
    static final long ID_2 = 2L;

    @InjectMocks
    OwnerServiceJpa ownerServiceJpa;

    @Mock
    OwnerRepository ownerRepository;

    @BeforeEach
    void setUp() {
        testOwner1 = new Owner();
        testOwner1.setId(ID_1);
        testOwner1.setFirstName(FIRST_NAME_1);
        testOwner1.setLastName(LAST_NAME_1);

        testOwner2 = new Owner();
        testOwner2.setId(ID_2);
        testOwner2.setFirstName(FIRST_NAME_2);
        testOwner2.setLastName(LAST_NAME_2);

        owners = new HashSet<>();
        owners.add(testOwner1);
        owners.add(testOwner2);
    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> ownerSet = ownerServiceJpa.findAll();
        assertNotNull(ownerSet);
        assertEquals(2, ownerSet.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.ofNullable(testOwner1));
        Owner owner = ownerServiceJpa.findById(ID_1);
        assertEquals(1L, owner.getId());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerServiceJpa.findById(ID_1);
        assertNull(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(testOwner1);
        assertNotNull(ownerServiceJpa.save(testOwner1));
    }

    @Test
    void delete() {
        ownerServiceJpa.delete(testOwner1);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerServiceJpa.deleteById(ID_1);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(testOwner1);
        assertEquals(LAST_NAME_1, ownerServiceJpa.findByLastName(LAST_NAME_1).getLastName());
    }
}