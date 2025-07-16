package org.app.entity.creature;

import org.app.Config;
import org.app.model.DietType;
import org.app.model.EntityType;
import org.app.simulation.Pathfinder;

public class Predator extends Creature {
    // Поля
    protected int attackPower;

    // Конструктор
    public Predator(int row, int col, Pathfinder pathfinder) {
        super(  row,
                col,
                EntityType.PREDATOR,
                Config.PREDATOR_MAX_HEALTH,
                Config.PREDATOR_SPEED,
                DietType.PREDATOR,
                pathfinder,
                Config.PREDATOR_HUNGER_THRESHOLD,
                Config.PREDATOR_HUNGER_DAMAGE
        );
        this.attackPower = Config.PREDATOR_ATTACK_POWER;
    }

    // Оверрайд методи
    @Override
    public String render() {
        return "P";
    }

    @Override
    public int getAttackPower() {
        return Config.PREDATOR_ATTACK_POWER;
    }

    @Override
    protected void onKill(Creature prey) {
        this.moveCount = 0;
        hp = Math.min(maxHp, hp + Config.PREDATOR_HEALTH_RESTORE);
    }

    // Методи




}
