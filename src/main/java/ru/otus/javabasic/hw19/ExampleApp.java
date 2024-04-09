package ru.otus.javabasic.hw19;

import ru.otus.javabasic.hw19.box.Box;
import ru.otus.javabasic.hw19.fruit.Apple;
import ru.otus.javabasic.hw19.fruit.Fruit;
import ru.otus.javabasic.hw19.fruit.Orange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExampleApp {
    public static void main(String[] args) {
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box();
        Box<Fruit> fruitBox = new Box<>();

        for (int i = 0; i < 3; i++) {
            appleBox.add(new Apple("Green Apple", 2));
            orangeBox.add(new Orange("Apelsin", 1));
        }

        System.out.println(orangeBox);
        System.out.println(appleBox);
        System.out.println("-".repeat(10));
        appleBox.transferTo(fruitBox);
        orangeBox.transferTo(fruitBox);
        System.out.println(orangeBox);
        System.out.println(appleBox);
        System.out.println(fruitBox);

//        List<Box<? extends Fruit>> l = new ArrayList<>();
//        l.add(appleBox);
//        l.add(orangeBox);
//        System.out.println(l);
//        System.out.println("sorting");
//        Collections.sort(l);
//        System.out.println(l);
    }
}
