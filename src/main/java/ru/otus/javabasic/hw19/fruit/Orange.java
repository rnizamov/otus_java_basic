package ru.otus.javabasic.hw19.fruit;

public class Orange extends Fruit{
    public Orange(String name, double density) {
        super(name, density);
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}