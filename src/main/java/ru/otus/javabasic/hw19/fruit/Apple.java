package ru.otus.javabasic.hw19.fruit;

public class Apple extends Fruit{
    public Apple(String name, double density) {
        super(name, density);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}