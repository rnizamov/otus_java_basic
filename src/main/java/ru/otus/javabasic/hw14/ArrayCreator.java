package ru.otus.javabasic.hw14;

public class ArrayCreator {
    public static double[] getDoubleArray(int size) {
        double[] array = new double[size];
        return array;
    }

    public static void fillArray(double[] array, int i, int end) {
        for (; i < end; i++) {
            array[i] =  1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }
}
