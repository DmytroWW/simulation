package org.app.creature;

import org.app.Config;
import org.app.EntityType;
import org.app.entity.Entity;

public class Herbivore extends Creature {

    // Конструктор
    public Herbivore(int row, int col) {
        super(row, col, EntityType.HERBIVORE, Config.HERBIVORE_MAX_HEALTH, Config.HERBIVORE_SPEED);
    }


    // Оверрайд методи
    @Override
    public Entity spawn(int newRow, int newCol) {
        return new Herbivore(newRow, newCol);
    }
    @Override
    public String render() {
        return "H";
    }

    // Власний метод класу


}
