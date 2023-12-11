package ru.otus.javabasic.hw6;

public class Cat {
    private String name;
    private float appetite;
    boolean fill;

    public Cat(String name, float appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void info() {
        System.out.println("name = " + name);
        System.out.println("appetite = " + appetite);
        System.out.println("fill = " + fill);
    }

    public void eat(Plate plate) {
        if (plate.getCurrentCount() >= appetite) {
            plate.minus(appetite);
            fill = true;
            System.out.println("котик поел");
            return;
        }
        System.out.println("котик не стал есть из тарелки");
    }
}
