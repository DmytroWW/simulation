package org.app.entity;

import org.app.model.EntityType;

public class Grass extends Entity{

    // Конструктор
    public Grass(int row, int col) {
        super(row, col, EntityType.GRASS);
    }


    // Оверрайд методи
    @Override
    public String render() {
        return "G";
    }
}
