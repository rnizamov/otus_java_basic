package ru.otus.javabasic.hw3;

public class HomeWork3 {
    // Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив,
    // метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;
    public static int sumOfPositiveElements(int[]... array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    sum += array[i][j];
                }
            }
        }
        return sum;
    }

    //Реализовать метод, который принимает в качестве аргумента int size
    // и печатает в консоль квадрат из символов * со сторонами соответствующей длины;
    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив, и
    // зануляющий его диагональные элементы (можете выбрать любую из диагоналей, или занулить обе);
    public static void resetsDiagonals(int[]... array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || (i + j == array.length - 1)) {
                    array[i][j] = 0;
                }
            }
        }
    }

    //Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
    public static int findMax(int[]... array) {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    // Реализуйте метод, который считает сумму элементов второй строки двумерного массива,
    // если второй строки не существует, то в качестве результата необходимо вернуть -1
    public static int sumSecondInnerArray(int[]... array) {
        int sum = 0;
        if (array.length < 2) {
            return -1;
        }
        for (int i = 0; i < array[1].length; i++) {
            sum += array[1][i];
        }
        return sum;
    }
}