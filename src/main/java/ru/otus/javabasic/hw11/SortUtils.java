package ru.otus.javabasic.hw11;

import java.util.Arrays;

public class SortUtils {
    public static void bubbleSort(int array[]) {
        boolean needSort = true;
        while (needSort) {
            needSort = false;
            for (int i = 0; i < array.length - 1; i++) {
                int buff = 0;
                if (array[i] > array[i+1]) {
                    buff = array[i+1];
                    array[i+1] = array[i];
                    array[i] = buff;
                    needSort = true;
                }
            }
        }
    }

    public static void quickSort(int array[]) {

    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,4,1,2,12,124,444};

        bubbleSort(arr);
    }
}
