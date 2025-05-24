package org.app.creature;

import org.app.Config;
import org.app.EntityType;

public class Predator extends Creature {
    // Поля
    protected int attackPower;

    // Конструктор
    public Predator(int row, int col) {
        super(row, col, EntityType.PREDATOR, Config.PREDATOR_MAX_HEALTH, Config.PREDATOR_SPEED);
        this.attackPower = Config.PREDATOR_ATTACK_POWER;
    }

    // Методи

}
