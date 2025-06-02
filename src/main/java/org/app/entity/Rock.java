package org.app.entity;

import org.app.model.EntityType;

public class Rock extends Entity {

    // конструктор
    public Rock(int row, int col) {
        super(row, col, EntityType.ROCK);
    }


    // Оверрайд методи
    @Override
    public String render() {
        return "R";
    }
}
