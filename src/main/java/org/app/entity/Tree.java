package org.app.entity;

import org.app.EntityType;

public class Tree extends Entity {
    public Tree(int row, int col) {
        super(row, col, EntityType.TREE);
    }


    // Оверрайд методи
    @Override
    public Entity spawn(int newRow, int newCol) {
        return new Tree(newRow, newCol);
    }
    @Override
    public String render() {
        return "T";
    }
}
