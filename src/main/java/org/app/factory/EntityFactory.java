package org.app.factory;


import org.app.model.EntityType;
import org.app.entity.Entity;
import org.app.entity.Grass;
import org.app.entity.Rock;
import org.app.entity.Tree;
import org.app.entity.creature.Herbivore;
import org.app.entity.creature.Predator;
import org.app.simulation.Pathfinder;

public final class EntityFactory {

    // конструктор
    private EntityFactory() {}

    public static Entity create(EntityType type, int row, int col, Pathfinder pathfinder) {

        return switch (type) {
            case EntityType.HERBIVORE -> new Herbivore(row, col, pathfinder);
            case EntityType.PREDATOR -> new Predator(row, col, pathfinder);
            case EntityType.GRASS -> new Grass(row, col, pathfinder.getMap());
            case EntityType.ROCK -> new Rock(row, col);
            case EntityType.TREE -> new Tree(row, col);

        };
    }
}
