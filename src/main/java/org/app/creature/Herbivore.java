package org.app.creature;

import org.app.Config;

public class Herbivore extends Creature {

    // Конструктор
    public Herbivore(int x, int y) {
        super(x, y, "Herbivore", Config.HERBIVORE_MAX_HEALTH, Config.HERBIVORE_SPEED);
    }
}
