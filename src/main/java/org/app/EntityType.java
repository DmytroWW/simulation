package org.app;

public enum EntityType {
    HERBIVORE,
    PREDATOR,
    GRASS,
    ROCK,
    TREE;

    public char getSymbol() {
        return switch(this) {
            case HERBIVORE -> 'H';
            case PREDATOR -> 'P';
            case GRASS -> 'G';
            case ROCK -> 'R';
            case TREE -> 'T';
        };
    }
}
