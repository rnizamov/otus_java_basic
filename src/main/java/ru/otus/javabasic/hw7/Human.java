package ru.otus.javabasic.hw7;

import ru.otus.javabasic.hw7.constants.Terrain;
import ru.otus.javabasic.hw7.interfaces.IMove;
import ru.otus.javabasic.hw7.interfaces.Transport;

public class Human implements IMove {
    private String name;
    private float maxDistance;
    private Transport transport;
    private float resources;

    public Human(String name, float maxDistance, float resources) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.resources = resources;
    }

    public void useTransport(Transport transport) {
        if (transport.getOwner() == this) {
            System.out.println("Уже используется этот транспорт: " + transport.getClass().getSimpleName());
            return;
        }
        if (transport.getOwner() != null) {
            System.out.println("У этого транспорта уже есть владелец!");
            return;
        }
        if (this.transport != null) {
            unUseTransport();
        }
        this.transport = transport;
        this.transport.setOwner(this);
        System.out.println(name + " использует транспорт: " + transport.getClass().getSimpleName());
    }

    public void unUseTransport() {
        if (transport == null) {
            return;
        }
        System.out.println(name + " перестал использовать транспорт: " + transport.getClass().getSimpleName());
        transport.setOwner(null);
        transport = null;
    }

    @Override
    public boolean move(double distance, Terrain terrain) {
        System.out.println();
        if (transport != null) {
            return transport.move(distance, terrain);
        } else {
            return walking(distance, terrain);
        }
    }

    private boolean walking(double distance, Terrain terrain) {
        double requiredResources = distance * 5;
        if (distance > maxDistance) {
            System.out.println("Так далеко пешком не пройду!");
            System.out.println("distance: " + distance + " maxDistance " + maxDistance);
            return false;
        }
        if (requiredResources > resources) {
            System.out.println("не хватает сил для передвижения");
            return false;
        }
        resources -= requiredResources;
        maxDistance -= distance;
        System.out.println(name + " прошел пешком расстояние: " + distance + " по локации " + terrain.getName());
        info();
        return true;
    }

    public void info() {
        System.out.println("name = " + name);
        System.out.println("maxDistance = " + maxDistance);
        System.out.println("resources = " + resources);
    }
}