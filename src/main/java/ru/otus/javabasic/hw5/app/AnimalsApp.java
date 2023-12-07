package ru.otus.javabasic.hw5.app;

import ru.otus.javabasic.hw5.animals.Animal;
import ru.otus.javabasic.hw5.animals.Cat;
import ru.otus.javabasic.hw5.animals.Dog;
import ru.otus.javabasic.hw5.animals.Horse;

public class AnimalsApp {
    public static void main(String[] args) {
        testCat();
    }

    public static void testCat() {
        Animal cat = new Cat("Barsik", 1, 1, 10);
        System.out.println(cat.run(555));
        cat.info();
        System.out.println(cat.swim(5));
        cat.info();
    }

    public static void testDog() {
        Animal dog = new Dog("Hatiko", 2, 2, 20);
        System.out.println(dog.run(5));
        dog.info();
        System.out.println(dog.swim(5));
        dog.info();
    }

    public static void testHorse() {
        Animal horse = new Horse("Jerebec", 10, 3, 100);
        System.out.println(horse.run(10));
        horse.info();
        System.out.println(horse.swim(10));
        horse.info();
    }
}