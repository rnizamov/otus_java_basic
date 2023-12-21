package ru.otus.javabasic.hw7.interfaces;
import ru.otus.javabasic.hw7.constants.Terrain;

public interface IMove {
    boolean move(double distance, Terrain terrain);
}
