package ru.otus.javabasic.hw5.animals;

public class Cat extends Animal {
    public Cat(String name, int runSpeed, int swimSpeed, int stamina) {
        super(name, runSpeed, swimSpeed, stamina);
        swimFactor = 0;
    }
}
