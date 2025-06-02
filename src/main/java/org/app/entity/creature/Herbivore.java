package org.app.entity.creature;

import org.app.Config;
import org.app.model.EntityType;

public class Herbivore extends Creature {

    // Поля
    private final EntityType diet = EntityType.GRASS;


    // Конструктор
    public Herbivore(int row, int col) {
        super(row, col, EntityType.HERBIVORE, Config.HERBIVORE_MAX_HEALTH, Config.HERBIVORE_SPEED);
    }


    // Оверрайд методи
    @Override
    public String render() {
        return "H";
    }

    // Власний метод класу


}
