package org.app.actions;

import org.app.EntityType;
import org.app.entity.Entity;
import org.app.creature.Herbivore;
import org.app.creature.Predator;
import org.app.entity.Grass;
import org.app.entity.Rock;
import org.app.entity.Tree;


public class Actions {
    // Метод створює екземпляр сутності заданого типу на вказаних координатах.

    static Entity createEntity(EntityType type, int row, int col) {
        return switch (type) {
            case HERBIVORE -> new Herbivore(row, col);
            case PREDATOR -> new Predator(row, col);
            case GRASS -> new Grass(row, col);
            case ROCK -> new Rock(row, col);
            case TREE -> new Tree(row, col);
        };
    }
}
