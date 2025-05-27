package org.app.entity;

import org.app.EntityType;

public class Grass extends Entity{
    public Grass(int row, int col) {
        super(row, col, EntityType.GRASS);
    }


    // Оверрайд методи
    @Override
    public Entity spawn(int newRow, int newCol) {
        return new Grass(newRow, newCol);
    }
    @Override
    public String render() {
        return "G";
    }
}
