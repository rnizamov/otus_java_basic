package ru.otus.javabasic.hw19.fruit;

import java.util.Objects;

public abstract class Fruit implements Comparable<Fruit> {
    protected final double density;
    protected final String name;

    public Fruit(String name, double density) {
        this.name = name;
        this.density = density;
    }

    public Double getDensity() {
        return density;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Fruit o) {
        return getDensity().compareTo(o.getDensity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Double.compare(fruit.density, density) == 0 && Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(density, name);
    }
}