package ru.otus.javabasic.hw5.animals;

public class Cat extends Animal {
    public Cat(String name, float runSpeed, float swimSpeed, float stamina) {
        super(name, runSpeed, swimSpeed, stamina);
        swimFactor = 0;
    }
}
