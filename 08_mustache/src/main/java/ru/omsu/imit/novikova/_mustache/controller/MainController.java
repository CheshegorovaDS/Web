package ru.omsu.imit.novikova._mustache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.omsu.imit.novikova._mustache.dao.AnimalDAO;
import ru.omsu.imit.novikova._mustache.model.Animal;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private AnimalDAO animalDAO;

    @RequestMapping("/")
    public String handleRequest(Model model) {
        List<Animal> animals = animalDAO.getAnimals();
        model.addAttribute("animals", animals);
        return "animal";
    }
}
