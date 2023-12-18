package ru.otus.javabasic.hw14;

import static ru.otus.javabasic.hw14.ArrayCreator.fillArray;
import static ru.otus.javabasic.hw14.ArrayCreator.getDoubleArray;

public class MultithreadedApp {
    public static void main(String[] args) throws InterruptedException {
        fillArrayByOneThread();
        fillArrayByMultiThreading();
    }

    public static void fillArrayByOneThread() {
        long time1 = System.currentTimeMillis();
        double[] array = getDoubleArray(100_000_000);
        fillArray(array, 0, array.length);
        System.out.println("Время заполнения массива в одном потоке: " + (System.currentTimeMillis() - time1));
    }

    public static void fillArrayByMultiThreading() throws InterruptedException {
        long time1 = System.currentTimeMillis();
        double[] array = getDoubleArray(100_000_000);
        Thread t1 = new Thread(() -> fillArray(array, 0, array.length / 4));
        Thread t2 = new Thread(() -> fillArray(array, array.length / 4, array.length / 2));
        Thread t3 = new Thread(() -> fillArray(array, array.length / 2, array.length *3/4));
        Thread t4 = new Thread(() -> fillArray(array, array.length *3/4, array.length));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Время заполнения массива в 4 потока: " + (System.currentTimeMillis() - time1));
    }
}