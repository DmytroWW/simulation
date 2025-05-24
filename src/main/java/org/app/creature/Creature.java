package org.app.creature;

import org.app.entity.Entity;

public abstract class Creature extends Entity {
    // Поля
    protected int hp;
    protected int speed;

    // Конструктор
    public Creature (int x, int y, String type, int hp, int speed) {
        super(x, y, type);
        this.hp = hp;
        this.speed = speed;
    }

    // Методи
    public void makeMove(){
    };
}
