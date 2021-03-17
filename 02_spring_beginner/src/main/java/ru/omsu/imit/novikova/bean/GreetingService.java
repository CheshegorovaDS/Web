package ru.omsu.imit.novikova.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.omsu.imit.novikova.lang.Language;

@Service
public class GreetingService {

    @Autowired
    private Language language;

    public GreetingService() {
    }

    public void sayHello() {
        String greeting = language.sayHello();

        System.out.println(greeting);
    }
}
