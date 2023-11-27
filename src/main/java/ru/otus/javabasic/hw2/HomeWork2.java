package ru.otus.javabasic.hw2;

import java.util.Arrays;

public class HomeWork2 {
    private static int[] array = new int[5];

    public static void printRow(int n, String row) {
        while (n > 0) {
            n--;
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
        int firstHalf = array.length / 2;
        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < firstHalf; i++) {
            sum1 += array[i];
        }

        for (int i = firstHalf; i < array.length; i++) {
            sum2 += array[i];
        }

        if (sum1 > sum2) {
            System.out.println("сумма элементов 1 половины больше");
        } else if (sum2 > sum1) {
            System.out.println("сумма элементов 2 половины больше");
        } else {
            System.out.println("половины равны");
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
        int k = array.length - 1;
        boolean hasPoint = false;

        while (true) {
            int border = array.length - k;
            int sumLeft = 0;
            int sumRight = 0;

            for (int i = 0; i < border; i++) {
                sumLeft += array[i];
            }
            for (int i = border; i < array.length; i++) {
                sumRight += array[i];
            }

            hasPoint = sumLeft == sumRight;
            --k;
            if (k == 0 || sumLeft == sumRight) break;
        }

        if (hasPoint) {
            System.out.println("Точка находится между элементами");
        } else {
            System.out.println("Точка не находится между элементами");
        }
    }

    // Реализуйте метод, проверяющий что все элементы массива идут в порядке убывания или
    // возрастания (по выбору пользователя)
    public static void checkArrayDirection(String direction, int[] array) {
        int cached = array[0];

        switch (direction) {
            case "ascending":
                for (int i = 1; i < array.length; i++) {
                    if (array[i] > cached) {
                        cached = array[i];
                    } else {
                        System.out.println("Не все элементы массива идут в порядке возрастания");
                        return;
                    }
                }
                System.out.println("все элементы массива идут в порядке возрастания");
                break;
            case "descending":
                for (int i = 1; i < array.length; i++) {
                    if (array[i] < cached) {
                        cached = array[i];
                    } else {
                        System.out.println("Не все элементы массива идут в порядке убывания");
                        return;
                    }
                }
                System.out.println("все элементы массива идут в порядке убывания");
                break;
        }
    }
}
