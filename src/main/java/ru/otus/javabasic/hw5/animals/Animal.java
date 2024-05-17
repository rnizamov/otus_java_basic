package ru.otus.javabasic.hw5.animals;

public abstract class Animal {
    protected String name;
    protected float runSpeed;
    protected float runFactor;
    protected float swimSpeed;
    protected float swimFactor;
    protected float stamina;

    public Animal(String name, float runSpeed, float runFactor, float swimSpeed, float swimFactor, float stamina) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.runFactor = runFactor;
        this.swimSpeed = swimSpeed;
        this.swimFactor = swimFactor;
        this.stamina = stamina;
    }

    public Animal(String name, float runSpeed, float swimSpeed, float stamina) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.stamina = stamina;
        runFactor = 1;
    }

    public float run(float distance) {
        return move("бег", distance, runSpeed, runFactor);
    }

    public float swim(float distance) {
        return move("плавание", distance, swimSpeed, swimFactor);
    }

    private float move(String description, float distance, float speed, float factor) {
        float requiredStamina = distance * factor;
        if (factor == 0 || speed == 0) {
            System.out.println("Действие " + description + " недоступно!");
            return -1F;
        }
        if (requiredStamina > stamina) {
            System.out.println("Недостаточно выносливости! Для действия " + description + " и дистанции " + distance);
            return -1F;
        }
        else {
            System.out.println(name + " выполняет " + description);
            stamina -= requiredStamina;
            return distance / speed;
        }
    }

    public void info() {
        System.out.println("name = " + name);
        System.out.println("runSpeed = " + runSpeed);
        System.out.println("runFactor = " + runFactor);
        System.out.println("swimSpeed = " + swimSpeed);
        System.out.println("swimFactor = " + swimFactor);
        System.out.println("stamina = " + stamina);
        System.out.println();
    }
}
