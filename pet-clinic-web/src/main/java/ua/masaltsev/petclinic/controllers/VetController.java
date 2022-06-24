package ua.masaltsev.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.masaltsev.petclinic.model.Vet;
import ua.masaltsev.petclinic.services.VetService;

import java.util.Set;

@Controller
public class VetController {

    private VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets.html", "/vets/index", "/vets/index.html"})
    public String listVets(Model model) {
        Set<Vet> vetSet = vetService.findAll();
        model.addAttribute("vets", vetSet);
        return "vets/index";
    }
}
