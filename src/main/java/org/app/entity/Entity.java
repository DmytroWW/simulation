package org.app.entity;

public abstract class Entity {
    public int x;
    public int y;
    public String type;

    public Entity(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
