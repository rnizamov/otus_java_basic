package ru.otus.javabasic.hw7.transports;

import ru.otus.javabasic.hw7.constants.Terrain;
import ru.otus.javabasic.hw7.interfaces.Transport;

public class HalfTrack extends Transport {

    public HalfTrack(float maxDistance, float resources, float costFactor) {
        super(maxDistance, resources, costFactor);
    }
}
