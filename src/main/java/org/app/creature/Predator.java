package org.app.creature;

import org.app.Config;
import org.app.EntityType;
import org.app.entity.Entity;

public class Predator extends Creature {
    // Поля
    protected int attackPower;

    // Конструктор
    public Predator(int row, int col) {
        super(row, col, EntityType.PREDATOR, Config.PREDATOR_MAX_HEALTH, Config.PREDATOR_SPEED);
        this.attackPower = Config.PREDATOR_ATTACK_POWER;
    }

    // Оверрайд методи
    @Override
    public Entity spawn(int newRow, int newCol) {
        return new Predator(newRow, newCol);
    }
    @Override
    public String render() {
        return "P";
    }

    // Методи




}
