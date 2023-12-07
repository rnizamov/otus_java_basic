package ru.otus.javabasic.hw5.animals;

public class Dog extends Animal {
    public Dog(String name, float speedRun, float factorRun, float speedSwim, float factorSwim, float stamina) {
        super(name, speedRun, factorRun, speedSwim, factorSwim, stamina);
    }

    public Dog(String name, float runSpeed, float swimSpeed, float stamina) {
        super(name, runSpeed, swimSpeed, stamina);
        swimFactor = 2;
    }
}
