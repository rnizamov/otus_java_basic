package ru.otus.javabasic.hw7.transports;

import ru.otus.javabasic.hw7.constants.Terrain;
import ru.otus.javabasic.hw7.interfaces.Transport;

import java.util.List;

public class Horse extends Transport {
    public Horse(float maxDistance, float resources, float costFactor) {
        super(maxDistance, resources, costFactor, List.of(Terrain.SWAMP));
    }
}