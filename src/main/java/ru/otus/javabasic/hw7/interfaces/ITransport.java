package ru.otus.javabasic.hw7.interfaces;
import ru.otus.javabasic.hw7.Human;
import ru.otus.javabasic.hw7.constants.Terrain;

public interface ITransport {
    boolean move(double distance, Terrain terrain);

    Human getOwner();

    void setOwner(Human human);
}
