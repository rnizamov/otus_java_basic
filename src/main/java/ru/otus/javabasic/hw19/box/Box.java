package ru.otus.javabasic.hw19.box;
import ru.otus.javabasic.hw19.fruit.Fruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box <E extends Fruit> implements Comparable<Box<?>>{
    private final List<E> storage = new ArrayList<>();

    public Box() {
    }

    public int countElements() {
        return storage.size();
    }

    public Double weight() {
        double weight = 0.0;
        for (E e : storage) {
            weight += e.getDensity();
        }
        return weight;
    }

    public void clear() {
        storage.clear();
    }

    public boolean remove(E element) {
        if (storage.contains(element)) {
            storage.remove(element);
            return true;
        } else return false;
    }

    public boolean remove(int index) {
        if (index + 1 > storage.size())  {
            return false;
        } else {
            storage.remove(index);
            return true;
        }
    }

    public void sorting() {
        Collections.sort(storage);
    }

    public void add(E element) {
        storage.add(element);
    }

    public void transferTo(Box<? super E> box) {
        box.storage.addAll(storage);
        box.sorting();
        clear();
    }

    public boolean compare(Box<?> o) {
        if (compareTo(o) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Box<?> o) {
        return weight().compareTo(o.weight());
    }

    @Override
    public String toString() {
        return "Box{" +
                "storage=" + storage +
                '}';
    }
}