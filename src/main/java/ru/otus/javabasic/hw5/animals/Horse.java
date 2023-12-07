package ru.otus.javabasic.hw5.animals;

public class Horse extends Animal {
    public Horse(String name, int speedRun, int factorRun, int speedSwim, int factorSwim, int stamina) {
        super(name, speedRun, factorRun, speedSwim, factorSwim, stamina);
    }

    public Horse(String name, int runSpeed, int swimSpeed, int stamina) {
        super(name, runSpeed, swimSpeed, stamina);
        swimFactor = 4;
    }
}
