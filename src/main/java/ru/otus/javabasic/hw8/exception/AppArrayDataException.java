package ru.otus.javabasic.hw8.exception;

public class AppArrayDataException extends RuntimeException {
    public AppArrayDataException(int i, int j) {
        super("не верный формат данных в ячейке i: " + i + " j: " + j);
    }
}
