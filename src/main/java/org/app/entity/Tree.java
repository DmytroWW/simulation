package org.app.entity;

import org.app.model.EntityType;


public class Tree extends Entity {

    //конструктор
    public Tree(int row, int col) {
        super(row, col, EntityType.TREE);
    }


    // Оверрайд методи
    @Override
    public String render() {
        return "T";
    }
}
