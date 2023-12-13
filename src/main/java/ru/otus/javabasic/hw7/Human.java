package ru.otus.javabasic.hw7;
import ru.otus.javabasic.hw7.constants.Terrain;
import ru.otus.javabasic.hw7.interfaces.ITransport;

public class Human {
    private String name;
    private float maxDistance;
    private ITransport transport;
    private float resources;

    public Human(String name, float maxDistance, float resources) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.resources = resources;
    }

    public void useTransport(ITransport transport) {
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

    public void move(float distance, Terrain terrain) {
        System.out.println();
        if (transport != null) {
            switch (transport.getClass().getSimpleName()) {
                case ("Bike"):
                    movementOnTransport(distance, terrain, 4);
                    break;
                case ("Car"):
                    movementOnTransport(distance, terrain, 1);
                    break;
                case ("HalfTrack"):
                    movementOnTransport(distance, terrain, 2);
                    break;
                case ("Horse"):
                    movementOnTransport(distance, terrain, 3);
                    break;
            }
        } else {
            walking(distance, terrain);
        }
        info();
    }

    private void movementOnTransport(float distance, Terrain terrain, float costFactor) {
        float requiredResources = distance * costFactor;
        if (requiredResources > resources) {
            System.out.println("не хватает сил для передвижения");
            return;
        }
        transport.move(distance, terrain);
        resources -= requiredResources;
    }

    private void walking(float distance, Terrain terrain) {
        float requiredResources = distance * 5;
        if (distance > maxDistance) {
            System.out.println("Так далеко пешком не пройду!");
            System.out.println("distance: " + distance + " maxDistance " + maxDistance);
            return;
        }
        if (requiredResources > resources) {
            System.out.println("не хватает сил для передвижения");
            return;
        }
        resources -= requiredResources;
        maxDistance -= distance;
        System.out.println(name + " прошел пешком расстояние: " + distance + " по локации " + terrain.getName());
    }

    public void info() {
        System.out.println("name = " + name);
        System.out.println("maxDistance = " + maxDistance);
        System.out.println("resources = " + resources);
    }
}