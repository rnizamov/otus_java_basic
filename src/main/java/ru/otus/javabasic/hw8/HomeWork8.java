package ru.otus.javabasic.hw8;

import ru.otus.javabasic.hw8.exception.AppArrayDataException;
import ru.otus.javabasic.hw8.exception.AppArraySizeException;

public class HomeWork8 {
    public static int sumAllElementsArraySize4x4(String[][] array) {
        int sum = 0;
        if (array.length != 4) {
            throw new AppArraySizeException(4, 4);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new AppArraySizeException(4, 4);
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}