package ru.omsu.imit.novikova._spring_and_groovy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import ru.omsu.imit.novikova._spring_and_groovy.model.Animal;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private static List<Animal> list = new ArrayList();

    static {
        list.add(new Animal("Сёма","Попугай"));
        list.add(new Animal("Мурка","Кошка"));
    }

    @RequestMapping(value = "/")
    public String handleRequest(Model model) {
        String message = "Animal List:";

        model.addAttribute("message", message);
        model.addAttribute("animals", list);

        return "start";
    }
}
