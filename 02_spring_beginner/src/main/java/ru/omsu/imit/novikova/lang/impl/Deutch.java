package ru.omsu.imit.novikova.lang.impl;

import ru.omsu.imit.novikova.lang.Language;

public class Deutch implements Language {
    @Override
    public String sayHello() {
        return "Guten tag, World";
    }

    @Override
    public String sayBye() {
        return "Auf Wiedersehen, World";
    }
}
