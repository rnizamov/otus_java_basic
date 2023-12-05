package ru.otus.javabasic.hw5.animals;

public abstract class Animal {
    protected String name;
    protected float speedForce;
    protected int stamina;

    public Animal(String name, int speedForce, int stamina) {
        this.name = name;
        this.speedForce = speedForce;
        this.stamina = stamina;
    }

    public float run(int distance) {
        System.out.println(name + " побежал");
        float time = 0;
        for (int i = 0; i < distance; i++) {
            if (stamina <= 0) {
                System.out.println("состояние усталости!");
                return -1;
            }
            stamina--;
            time += 1/speedForce;
        }
        return time;
    }

    public void info() {
        System.out.println("name = " + name);
        System.out.println("speedForce = " + speedForce);
        System.out.println("stamina = " + stamina);
    }
}
