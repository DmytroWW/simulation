package org.app.creature;

import org.app.EntityType;
import org.app.entity.Entity;

public abstract class Creature extends Entity {
    // Поля
    protected int hp;
    protected int speed;

    // Конструктор
    public Creature (int row, int col, EntityType type, int hp, int speed) {
        super(row, col, type);
        this.hp = hp;
        this.speed = speed;
    }

    // Методи
    public void makeMove(){
    };
}
