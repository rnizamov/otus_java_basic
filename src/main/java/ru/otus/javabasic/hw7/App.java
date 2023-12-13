package ru.otus.javabasic.hw7;

import ru.otus.javabasic.hw7.constants.Terrain;
import ru.otus.javabasic.hw7.interfaces.ITransport;
import ru.otus.javabasic.hw7.interfaces.Transport;
import ru.otus.javabasic.hw7.transports.Bike;
import ru.otus.javabasic.hw7.transports.Car;
import ru.otus.javabasic.hw7.transports.HalfTrack;
import ru.otus.javabasic.hw7.transports.Horse;

public class App {
    public static void main(String[] args) {
        useOfMultipleTransports();
     }

    public static void useOfMultipleTransports() {
        Human human = new Human("Vasya", 1000, 500);

        ITransport transport1 = new Bike();
        ITransport transport2 = new Car(5000, 2000, 15);
        ITransport transport3 = new Horse(500, 500, 20);
        ITransport transport4 = new HalfTrack(750, 750, 10);

        human.useTransport(transport1);
        human.move(12, Terrain.FLATLAND);

        human.useTransport(transport2);
        human.move(50, Terrain.FLATLAND);
        human.move(10, Terrain.FLATLAND);

        human.useTransport(transport3);
        human.move(25, Terrain.FOREST);

        human.useTransport(transport4);
        human.move(50, Terrain.SWAMP);

        human.unUseTransport();
        human.move(10, Terrain.FLATLAND);
    }

    public static void changeTransport() {
        Human human = new Human("Vasya", 1000, 500);
        ITransport transport1 = new Bike();
        ITransport transport2 = new Car(5000, 20, 1);

        human.useTransport(transport1);
        human.useTransport(transport2);

        human.move(6, Terrain.FLATLAND);
    }

    public static void takeSomeOneElseSTransport() {
        Human human1 = new Human("Vasya", 1000, 500);
        Human human2 = new Human("Petya", 500, 500);
        ITransport transport1 = new Bike();

        human1.useTransport(transport1);
        human2.useTransport(transport1);
    }
}
