package ru.omsu.imit.novikova._mustache.model;

public class Animal {
    private Long id;
    private String name;
    private String category;
    private int age;

    public Animal() {
    }

    public Animal(Long id, String name, String category, int age) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
