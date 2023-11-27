package ru.otus.javabasic.hw1;

import java.util.Scanner;

public class HomeWork1 {

    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    public static void checkSign(int a, int b, int c) {
        if (a + b + c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");

        }
    }

    public static void selectColor() {
        int data = 20;

        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 5;
        int b = 10;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }

    public static void askUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Уважаемый пользователь, введите пожалуйста число от 1 до 5 :");
        int order = scanner.nextInt();
        switch (order) {
            case 1:
                greetings();
                break;
            case 2:
                checkSign(-1, 0, 1);
                break;
            case 3:
                selectColor();
                break;
            case 4:
                compareNumbers();
                break;
            case 5:
                addOrSubtractAndPrint(0, 15, false);
                break;
        }
    }

    public static void main(String[] args) {
        greetings();
        checkSign(-1, 0, 1);
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint(0, 15, false);

        askUser();
    }
}
