package ua.masaltsev.petclinic.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ua.masaltsev.petclinic.model.Owner;
import ua.masaltsev.petclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    Set<Owner> owners;
    Owner testOwner1;
    Owner testOwner2;

    MockMvc mockMvc;

    static final String FIRST_NAME_1 = "Stepan";
    static final String LAST_NAME_1 = "Gryshko";
    static final long ID_1 = 1L;

    static final String FIRST_NAME_2 = "Olga";
    static final String LAST_NAME_2 = "Kruchko";
    static final long ID_2 = 2L;

    @InjectMocks
    OwnerController ownerController;

    @Mock
    OwnerService ownerService;

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
        mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("owners/index"))
                .andExpect(MockMvcResultMatchers.model().attribute("owners", Matchers.hasSize(2)));
    }

    @Test
    void indexTwo() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/index"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("owners/index"))
                .andExpect(MockMvcResultMatchers.model().attribute("owners", Matchers.hasSize(2)));
    }

    @Test
    void find() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/find"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("not_implemented"));

        verifyNoInteractions(ownerService);
    }





















}