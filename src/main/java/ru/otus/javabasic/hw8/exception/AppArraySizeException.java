package ru.otus.javabasic.hw8.exception;

public class AppArraySizeException extends RuntimeException {

    public AppArraySizeException(int count) {
        super("Не верный размер массива != 4х4");
    }
}
