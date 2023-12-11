package ru.otus.javabasic.hw6;

public class Plate {
    private float maxCount;
    private float currentCount;

    public Plate(float maxCount) {
        this.maxCount = maxCount;
        currentCount = maxCount;
    }

    public float getCurrentCount() {
        return currentCount;
    }

    public boolean add(float countEat) {
        if (maxCount < currentCount + countEat) {
            return false;
        }
        currentCount += countEat;
        return true;
    }

    public boolean minus(float countEat) {
        if (currentCount - countEat >= 0) {
            currentCount -= countEat;
            return true;
        }
        return false;
    }

    public void info() {
        System.out.println("maxCount = " + maxCount);
        System.out.println("currentCount = " + currentCount);
    }
}
