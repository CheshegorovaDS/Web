package ru.omsu.imit.novikova._free_marker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.omsu.imit.novikova._free_marker.form.AnimalForm;
import ru.omsu.imit.novikova._free_marker.model.Animal;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private static List<Animal> list = new ArrayList<Animal>();

    static {
        list.add(new Animal("Сёма","Попугай"));
        list.add(new Animal("Мурка","Кошка"));
    }

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/", "/start" }, method = RequestMethod.GET)
    public String start(Model model) {
        model.addAttribute("message", message);
        return "start";
    }

    @RequestMapping(value = { "/listAnimal" }, method = RequestMethod.GET)
    public String listAnimal(Model model) {
        model.addAttribute("animals", list);
        return "listAnimal";
    }

    @RequestMapping(value = { "/addAnimal" }, method = RequestMethod.GET)
    public String showAddAnimalPage(Model model) {
        AnimalForm animalForm = new AnimalForm();
        model.addAttribute("animalForm", animalForm);
        return "addAnimal";
    }

    @RequestMapping(value = { "/addAnimal" }, method = RequestMethod.POST)
    public String saveAnimal(
            Model model,
            @ModelAttribute("animalForm") AnimalForm animalForm
    ) {
        String name = animalForm.getName();
        String category = animalForm.getCategory();

        if (name != null && name.length() > 0
                && category != null && category.length() > 0) {
            Animal newAnimal = new Animal(name, category);
            list.add(newAnimal);
            return "redirect:/listAnimal";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addAnimal";
    }

}
