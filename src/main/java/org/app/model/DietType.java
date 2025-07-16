package org.app.model;

import java.util.EnumSet;

public enum DietType {

    HERBIVORE(EnumSet.of(EntityType.GRASS)),
    PREDATOR(EnumSet.of(EntityType.HERBIVORE));

    private final EnumSet<EntityType> preySet;

    DietType(EnumSet<EntityType> preySet) {
        this.preySet = preySet;
    }

    public boolean canEat(EntityType type) {
        return preySet.contains(type);
    }



}
