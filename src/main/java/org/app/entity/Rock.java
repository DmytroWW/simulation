package org.app.entity;

import org.app.EntityType;

public class Rock extends Entity {
    public Rock(int row, int col) {
        super(row, col, EntityType.ROCK);
    }


    // Оверрайд методи
    @Override
    public Entity spawn(int newRow, int newCol) {
        return new Rock(newRow, newCol);
    }
    @Override
    public String render() {
        return "R";
    }
}
