package ru.otus.javabasic.hw14;

import static ru.otus.javabasic.hw14.ArrayCreator.fillArray;
import static ru.otus.javabasic.hw14.ArrayCreator.getDoubleArray;

public class MultithreadedApp {
    static final int SIZE_ARRAY = 100_000_000;
    public static void main(String[] args) throws InterruptedException {
        fillArrayByOneThread(SIZE_ARRAY);
        fillArrayByMultiThreading(SIZE_ARRAY, 4);
    }

    public static void fillArrayByOneThread(int sizeArray) {
        long time1 = System.currentTimeMillis();
        double[] array = getDoubleArray(sizeArray);
        fillArray(array, 0, array.length);
        System.out.println("Время заполнения массива в одном потоке: " + (System.currentTimeMillis() - time1));
    }

    public static void fillArrayByMultiThreading(int sizeArray, int countThreads) throws InterruptedException {
        long time1 = System.currentTimeMillis();
        double[] array = getDoubleArray(sizeArray);
        int part = array.length / countThreads;
        Thread[] threadArray = new Thread[countThreads];
        for (int i = 0; i < countThreads; i++) {
            int start = part * i;
            int end = part * (i + 1);
            threadArray[i] = new Thread(() -> fillArray(array, start, end));
        }
        for (Thread thread : threadArray) {
            thread.start();
        }
        for (Thread thread : threadArray) {
            thread.join();
        }
        System.out.println("Время заполнения массива в " + countThreads + " потока: " + (System.currentTimeMillis() - time1));
    }
}