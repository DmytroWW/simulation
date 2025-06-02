package org.app.entity.creature;

import org.app.model.EntityType;
import org.app.entity.Entity;

public abstract class Creature extends Entity {
    // Поля
    protected int hp;
    protected int speed;
    protected EntityType diet;

    // Конструктор
    public Creature (int row, int col, EntityType type, int hp, int speed) {
        super(row, col, type);
        this.hp = hp;
        this.speed = speed;
    }

    // Оверрайд методи

    @Override
    public abstract String render();

    // Методи
    public void makeMove(){

    };


}
