package ru.otus.javabasic.hw8.exception;

public class AppArraySizeException extends RuntimeException {

    public AppArraySizeException(int i, int j) {
        super("Не верный размер массива != " + i + "х" + j);
    }
}
