package ru.omsu.imit.novikova._mustache.dao;

import org.springframework.stereotype.Repository;
import ru.omsu.imit.novikova._mustache.model.Animal;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalDAO {

    public List<Animal> getAnimals() {
        Animal animal1 = new Animal(1L, "Мурка", "кошка", 13);
        Animal animal2 = new Animal(2L, "Сёма", "попугай", 5);

        List<Animal> animals = new ArrayList();
        animals.add(animal1);
        animals.add(animal2);

        return animals;
    }
}
