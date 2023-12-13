package ru.otus.javabasic.hw7.constants;

public enum Terrain {
    FOREST("густой лес"), FLATLAND("равнина"), SWAMP("болото");

    Terrain(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
