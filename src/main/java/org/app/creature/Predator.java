package org.app.creature;

import org.app.Config;

public class Predator extends Creature {
    // Поля
    protected int attackPower;

    // Конструктор
    public Predator(int x, int y) {
        super(x, y, "Predator", Config.PREDATOR_MAX_HEALTH, Config.PREDATOR_SPEED);
        this.attackPower = Config.PREDATOR_ATTACK_POWER;
    }

    // Методи

}
