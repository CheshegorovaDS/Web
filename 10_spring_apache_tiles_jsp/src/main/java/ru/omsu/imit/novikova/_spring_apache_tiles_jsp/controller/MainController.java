package ru.omsu.imit.novikova._spring_apache_tiles_jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.omsu.imit.novikova._spring_apache_tiles_jsp.model.Animal;

@Controller
public class MainController {

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(Model model) {
        return "homePage";
    }


    @RequestMapping(value = { "/animal" }, method = RequestMethod.GET)
    public String animalPage(Model model) {
        Animal animal = new Animal(1L, "Мурка", "Кошка", 13);
        model.addAttribute("name", animal.getName());
        model.addAttribute("category", animal.getCategory());
        return "animalPage";
    }
}
