package ru.otus.javabasic.hw6;

public class CatsApp {
    public static void main(String[] args) {
        Plate plate = new Plate(10F);

        Cat cat1 = new Cat("Murzik", 10F);
        Cat cat2 = new Cat("Barsik", 12.5F);
        Cat cat3 = new Cat("Samson", 3.3F);

        Cat[] cats = {cat1, cat2, cat3};

        for (Cat cat : cats) {
            System.out.println("-".repeat(30));
            cat.eat(plate);
            cat.info();
            System.out.println();
            plate.info();
        }
    }
}
