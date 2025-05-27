package org.app;

import org.app.creature.Herbivore;
import org.app.creature.Predator;
import org.app.entity.Entity;
import org.app.entity.Grass;
import org.app.entity.Rock;
import org.app.entity.Tree;



public enum EntityType {
    HERBIVORE(new Herbivore(-1, -1)),
    PREDATOR(new Predator(-1, -1)),
    GRASS(new Grass(-1, -1)),
    ROCK(new Rock(-1, -1)),
    TREE(new Tree(-1, -1));

    private final Entity prototype;

    EntityType(Entity prototype) {
        this.prototype = prototype;
    }

    public Entity create(int row, int col) {
        return prototype.spawn(row, col);
    }

}
