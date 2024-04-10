package ru.otus.javabasic.hw19.fruit;

import java.util.Objects;

public abstract class Fruit implements Comparable<Fruit> {
    protected final double weight;
    protected final String name;

    public Fruit(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Fruit o) {
        return getWeight().compareTo(o.getWeight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Double.compare(fruit.weight, weight) == 0 && Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, name);
    }
}