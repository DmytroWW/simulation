package org.app.entity;

import org.app.EntityType;

public class Rock extends Entity {
    public Rock(int row, int col) {
        super(row, col, EntityType.ROCK);
    }
}
