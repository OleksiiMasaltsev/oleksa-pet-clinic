package ua.masaltsev.petclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ua.masaltsev.petclinic.model.Owner;
import ua.masaltsev.petclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @InjectMocks
    OwnerController ownerController;

    @Mock
    OwnerService ownerService;

    MockMvc mockMvc;

    Set<Owner> owners;
    Owner testOwner1;
    Owner testOwner2;

    static final String FIRST_NAME_1 = "Stepan";
    static final String LAST_NAME_1 = "Gryshko";
    static final long ID_1 = 1L;

    static final String FIRST_NAME_2 = "Olga";
    static final String LAST_NAME_2 = "Kruchko";
    static final long ID_2 = 2L;

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

        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void index() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void indexTwo() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void find() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("not_implemented"));

        verifyNoInteractions(ownerService);
    }





















}