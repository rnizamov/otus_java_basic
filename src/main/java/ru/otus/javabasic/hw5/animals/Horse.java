package ru.otus.javabasic.hw5.animals;

public class Horse extends SwimmingAnimal {
    public Horse(String name, int speedForce, int stamina) {
        super(name, speedForce, stamina);
    }

    @Override
    public float swim(int distance) {
        System.out.println(name + " поплыл");
        float time = 0;
        for (int i = 0; i < distance; i++) {
            if (stamina <= 0) {
                System.out.println("состояние усталости!");
                return -1;
            }
            stamina -= 4;
            time += 1/speedForce;
        }
        return time;
    }
}
