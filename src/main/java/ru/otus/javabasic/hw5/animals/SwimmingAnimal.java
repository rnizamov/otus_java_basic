package ru.otus.javabasic.hw5.animals;

public abstract class SwimmingAnimal extends Animal {
    public SwimmingAnimal(String name, int speedForce, int stamina) {
        super(name, speedForce, stamina);
    }

    public abstract float swim(int distance);
}
