package ru.omsu.imit.novikova._jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.omsu.imit.novikova._jsp.model.Animal;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private static List<Animal> animals = new ArrayList<Animal>();

    static {
        animals.add(new Animal(1L, "Мурка", "кошка", 13));
        animals.add(new Animal(2L, "Сёма", "попугай", 5));
    }

    @RequestMapping(value = { "/", "/start" }, method = RequestMethod.GET)
    public String start(Model model) {

        String message = "Hello Spring Boot + JSP";

        model.addAttribute("message", message);

        return "start";
    }

    @RequestMapping(value = { "/animalList" }, method = RequestMethod.GET)
    public String viewAnimalList(Model model) {

        model.addAttribute("animals", animals);

        return "animalList";
    }

}
