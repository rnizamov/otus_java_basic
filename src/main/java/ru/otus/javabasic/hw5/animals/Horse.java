package ru.otus.javabasic.hw5.animals;

public class Horse extends Animal {
    public Horse(String name, float speedRun, float factorRun, float speedSwim, float factorSwim, float stamina) {
        super(name, speedRun, factorRun, speedSwim, factorSwim, stamina);
    }

    public Horse(String name, float runSpeed, float swimSpeed, float stamina) {
        super(name, runSpeed, swimSpeed, stamina);
        swimFactor = 4;
    }
}
