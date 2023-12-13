package ru.otus.javabasic.hw7.interfaces;

import ru.otus.javabasic.hw7.Human;
import ru.otus.javabasic.hw7.constants.Terrain;

import java.util.ArrayList;
import java.util.List;

public abstract class Transport implements ITransport {
    protected double maxDistance;
    protected double resources; // ресурсы
    protected double costFactor; // фактор затрат ресурсов на условную единицу дистанции
    private List<Terrain> lockedTerrain = new ArrayList<>();
    protected Human owner;

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }

    public Transport(double maxDistance, double resources, double costFactor) {
        this.maxDistance = maxDistance;
        this.resources = resources;
        this.costFactor = costFactor;
    }

    public Transport(double maxDistance, double resources, double costFactor, List<Terrain> lockedTerrain) {
        this(maxDistance, resources, costFactor);
        this.lockedTerrain = lockedTerrain;
    }

    @Override
    public boolean move(double distance, Terrain terrain) {
        double requiredResources = distance * costFactor;
        if (lockedTerrain.contains(terrain)) {
            System.out.println("Передвижение по локации \"" + terrain.getName() + "\" на транспорте " + this.getClass().getSimpleName() + " невозможно в принципе!");
            return false;
        }
        if (requiredResources > resources || distance > maxDistance) {
            System.out.println("Передвижение по локации \"" + terrain.getName() + "\" недоступно!");
            System.out.println("distance: " + distance + " requiredResources: " + requiredResources);
            info();
            return false;
        }
        maxDistance -= distance;
        resources -= requiredResources;
        System.out.println("Передвижение по локации \"" + terrain.getName() + "\" успешно!");
        info();
        return true;
    }

    public void info() {
        System.out.println("maxDistance = " + maxDistance);
        System.out.println("resources = " + resources);
    }
}
