package org.app.entity.creature;

import org.app.Config;
import org.app.model.EntityType;

public class Predator extends Creature {
    // Поля
    protected int attackPower;
    private final EntityType diet = EntityType.HERBIVORE;

    // Конструктор
    public Predator(int row, int col) {
        super(row, col, EntityType.PREDATOR, Config.PREDATOR_MAX_HEALTH, Config.PREDATOR_SPEED);
        this.attackPower = Config.PREDATOR_ATTACK_POWER;
    }

    // Оверрайд методи
    @Override
    public String render() {
        return "P";
    }

    // Методи




}
