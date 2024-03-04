package ru.otus.javabasic.hw8;

import ru.otus.javabasic.hw8.exception.AppArrayDataException;
import ru.otus.javabasic.hw8.exception.AppArraySizeException;

import static ru.otus.javabasic.hw8.HomeWork8.sumAllElementsArraySize4x4;

public class App {
    public static void main(String[] args) {
        try {
            int sum = sumAllElementsArraySize4x4(new String[][]{{"1", "1", "1", "1"},
                    {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}});
            System.out.println(sum);
        } catch (AppArrayDataException | AppArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }
}
