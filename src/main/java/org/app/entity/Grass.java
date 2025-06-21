package org.app.entity;

import org.app.Config;
import org.app.model.EntityType;

public class Grass extends Entity{
    private int hp = Config.GRASS_MAX_HEALTH;

    // Конструктор
    public Grass(int row, int col) {
        super(row, col, EntityType.GRASS);
    }


    // Оверрайд методи
    @Override
    public String render() {
        return "G";
    }

    @Override
    public void takeDamage(int amount) {
        hp -= amount;
        if (hp <= 0) {
            die();
        }
    }

    // свої методи
    public boolean isDead() {
        return hp <= 0;
    }

    protected void die() {
        // Видалити з карти через GameMap
    }
}
