package org.app.entity;

import org.app.EntityType;

public abstract class Entity {
    public int row;
    public int col;
    public EntityType type;

    public Entity(int row, int col, EntityType type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }
}
