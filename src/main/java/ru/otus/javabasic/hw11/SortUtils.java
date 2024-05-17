package ru.otus.javabasic.hw11;

public class SortUtils {
    public static void bubbleSort(int[] arr) {
        boolean needSort = true;
        while (needSort) {
            needSort = false;
            for (int i = 0; i < arr.length - 1; i++) {
                int buff = 0;
                if (arr[i] > arr[i + 1]) {
                    buff = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = buff;
                    needSort = true;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (arr.length == 0) {
            return;
        }

        int pivotIndex = start + (end - start) / 2;
        int pivotEl = arr[pivotIndex];

        int i = start;
        int j = end;

        while (i <= j) {
            while (arr[i] < pivotEl) {
                i++;
            }
            while (arr[j] > pivotEl) {
                j--;
            }
            if (i <= j) {
                int cache = arr[i];
                arr[i] = arr[j];
                arr[j] = cache;
                i++;
                j--;
            }
        }

        if (start < j) {
            quickSort(arr, start, j);
        }
        if (end > i) {
            quickSort(arr, i, end);
        }
    }
}