package ua.masaltsev.petclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ua.masaltsev.petclinic.model.Vet;
import ua.masaltsev.petclinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    @InjectMocks
    VetController vetController;

    @Mock
    VetService vetService;

    MockMvc mockMvc;

    Set<Vet> vets;
    Vet testVet1;
    Vet testVet2;

    static final String FIRST_NAME_1 = "Oleg";
    static final String LAST_NAME_1 = "Galushko";
    static final long ID_1 = 1L;

    static final String FIRST_NAME_2 = "Maria";
    static final String LAST_NAME_2 = "Naboka";
    static final long ID_2 = 2L;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(vetController).build();

        testVet1 = new Vet();
        testVet1.setFirstName(FIRST_NAME_1);
        testVet1.setLastName(LAST_NAME_1);
        testVet1.setId(ID_1);

        testVet2 = new Vet();
        testVet2.setFirstName(FIRST_NAME_2);
        testVet2.setLastName(LAST_NAME_2);
        testVet2.setId(ID_2);

        vets = new HashSet<>();
        vets.add(testVet1);
        vets.add(testVet2);
    }

    @Test
    void showVets_requestVets_returnsVetsIndex() throws Exception {
        when(vetService.findAll()).thenReturn(vets);
        mockMvc.perform(get("/vets"))
                .andExpect(status().isOk())
                .andExpect(view().name("vets/index"))
                .andExpect(model().attribute("vets", hasSize(2)));
    }













}