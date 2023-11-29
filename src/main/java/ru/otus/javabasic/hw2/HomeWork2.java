package ru.otus.javabasic.hw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork2 {
    private static int[] array = new int[5];

    public static void printRow(int n, String row) {
        for (int i = 0; i < n; i++) {
            System.out.println(row);
        }
    }

    public static void sumValuesGreaterThan5(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                sum += arr[i];
            }
        }
        System.out.println(sum);
    }

    public static void fillEachCellArray(int number, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = number;
        }
    }

    public static void increaseEachCellArray(int number, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += number;
        }
    }

    public static void calcMaxHalfArray(int[] array) {
        if (array.length == 0) {
            System.out.println("массив пустой!");
            return;
        }
        if (array.length == 1) {
            System.out.println("в массиве 1 элемент :" + array[0]);
            return;
        }

        int firstHalf = array.length / 2;
        int sum1 = 0, sum2 = 0;

        if (array.length % 2 != 0) {
            System.out.println("Внимание! Количество элементов в массиве нечетное!");
            System.out.println("Количество элементов левой части массива: " + firstHalf);
            System.out.println("Количество элементов правой части массива: " + (array.length - firstHalf));
        }

        for (int i = 0; i < firstHalf; i++) {
            sum1 += array[i];
        }
        for (int i = firstHalf; i < array.length; i++) {
            sum2 += array[i];
        }

        if (sum1 > sum2) {
            System.out.println("сумма элементов левой части массива больше");
        } else if (sum2 > sum1) {
            System.out.println("сумма элементов правой части массива больше");
        } else {
            System.out.println("сумма элементов левой и правой части массива равны");
        }
    }

    // Реализуйте метод, принимающий на вход набор целочисленных массивов, и получающий новый
    //массив равный сумме входящих;
    public static void arrayAddition(int[]... array) {
        int maxLength = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length > maxLength) {
                maxLength = array[i].length;
            }
        }

        int[] resultArray = new int[maxLength];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                resultArray[j] += array[i][j];
            }
        }
        System.out.println(Arrays.toString(resultArray));
    }

    // Реализуйте метод, проверяющий что есть “точка” в массиве, в которой сумма левой и правой части
//равны. “Точка находится между элементами”;
//Пример: { 1, 1, 1, 1, 1, | 5 }, { 5, | 3, 4, -2 }, { 7, 2, 2, 2 }, { 9, 4 }
    public static void hasPointOfArrayWhereSumsIsEquals(int[] array) {
        if (array.length == 0) {
            System.out.println("массив пустой!");
            return;
        }
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        if (sum % 2 != 0) {
            System.out.println("Точек сумм левой и правой части нет");
            return;
        }
        int halfSum = sum / 2;
        int sumElements = 0;
        for (int i = 0; i < array.length; i++) {
            sumElements += array[i];
            if (sumElements == halfSum) {
                System.out.println("Точка сумм левой и правой части находится между элементами");
                return;
            }
        }
        System.out.println("Точек сумм левой и правой части нет");
    }

    // Реализуйте метод, проверяющий что все элементы массива идут в порядке убывания или
    // возрастания (по выбору пользователя)
    public static void checkArrayDirection(String direction, int[] array) {
        if (array.length == 0) {
            System.out.println("массив пустой!");
            return;
        }
        int prevEl = array[0];
        for (int i = 1; i < array.length; i++) {
            if ((direction.equals("ascending") && array[i] < prevEl) || direction.equals("descending") && array[i] > prevEl) {
                System.out.println("Элементы не отсортированы в порядке: " + direction);
                return;
            }
            prevEl = array[i];
        }
        System.out.println("все элементы массива идут в порядке: " + direction);
    }
}