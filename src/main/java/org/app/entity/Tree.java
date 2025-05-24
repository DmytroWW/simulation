package org.app.entity;

import org.app.EntityType;

public class Tree extends Entity {
    public Tree(int row, int col) {
        super(row, col, EntityType.TREE);
    }
}
