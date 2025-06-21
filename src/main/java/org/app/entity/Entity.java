package org.app.entity;

import org.app.model.EntityType;

public abstract class Entity {
    private int row;
    private int col;
    private final EntityType type;

    // Конструктор
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

    public void takeDamage(int amount) {
        // За замовчуванням можна нічого не робити або логіку, якщо є
        // Цей метод залишиться для backward-compatibility
    }

    public void takeDamage(int amount, String reason) {
        // Викликаємо базовий варіант
        takeDamage(amount);
    }

    public abstract String render();
}
