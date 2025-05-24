package org.app.creature;

import org.app.Config;
import org.app.EntityType;

public class Herbivore extends Creature {

    // Конструктор
    public Herbivore(int row, int col) {
        super(row, col, EntityType.HERBIVORE, Config.HERBIVORE_MAX_HEALTH, Config.HERBIVORE_SPEED);
    }
}
