package org.app.entity;

import org.app.EntityType;

public abstract class Entity {
    private int row;
    private int col;
    private final EntityType type;

    public Entity(int row, int col, EntityType type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }

    public int getRow() { return row; }
    public void setRow(int row) { this.row = row; }

    public int getCol() { return col; }
    public void setCol(int col) { this.col = col; }

    public EntityType getType() { return type; }


    public abstract Entity spawn (int newRow, int newCol);
    public abstract String render();
}
