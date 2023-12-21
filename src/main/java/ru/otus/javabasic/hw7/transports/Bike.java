package ru.otus.javabasic.hw7.transports;

import ru.otus.javabasic.hw7.constants.Terrain;
import ru.otus.javabasic.hw7.interfaces.Transport;

import java.util.List;

public class Bike extends Transport {
    public Bike() {
        super(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0, List.of(Terrain.SWAMP));
    }
}
