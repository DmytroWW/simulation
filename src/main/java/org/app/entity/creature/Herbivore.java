package org.app.entity.creature;

import org.app.Config;
import org.app.model.DietType;
import org.app.model.EntityType;
import org.app.simulation.Pathfinder;

public class Herbivore extends Creature {

    // Поля



    // Конструктор
    public Herbivore(int row, int col, Pathfinder pathfinder) {
        super(  row,
                col,
                EntityType.HERBIVORE,
                Config.HERBIVORE_MAX_HEALTH,
                Config.HERBIVORE_SPEED,
                DietType.HERBIVORE,
                pathfinder,
                Config.HERBIVORE_HUNGER_THRESHOLD,
                Config.HERBIVORE_HUNGER_DAMAGE
        );
    }


    // Оверрайд методи
    @Override
    public String render() {
        return "H";
    }

    @Override
    public int getAttackPower() {
        return Config.HERBIVORE_ATTACK_POWER;
    }

    @Override
    protected void onEatGrass(org.app.entity.Grass grass) {
        this.moveCount = 0;
        hp = Math.min(maxHp, hp + Config.HERBIVORE_HEALTH_RESTORE);
    }

    // Власний метод класу


}
