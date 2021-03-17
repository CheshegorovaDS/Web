package ru.omsu.imit.novikova.lang.impl;

import ru.omsu.imit.novikova.lang.Language;

public class English implements Language {
    @Override
    public String sayHello() {
        return "Hello, World";
    }

    @Override
    public String sayBye() {
        return "Goodbye, World";
    }
}
