package org.app.simulation;

import org.app.Config;
import org.app.EntityType;
import org.app.entity.Entity;

public class GameMap {
    // Поле. Двовимірний масив що представляє карту.
    private Entity[][] grid;

    // Конструктор класу.
    public GameMap() {
        grid = new Entity[Config.MAP_HEIGHT][Config.MAP_WIDTH];
    }

    // Методи класу.

    // Перевірка чи координати в межах карти.
    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < Config.MAP_HEIGHT && col >= 0 && col < Config.MAP_WIDTH;
    }

    // Перевірка чи вільна клітинка.
    public boolean isCellEmpty(int row, int col) {
        return isInBounds(row, col) && grid[row][col] == null;
    }

    // Повертає об'єкт який знаходиться в клітинці
    public Entity getEntityAt(int row, int col) {
        if (!isInBounds(row, col)) return null;
        return grid[row][col];
    }

    public boolean PlaceEntityAt(EntityType type, int row, int col) {
        if (!isInBounds(row, col) || !isCellEmpty(row, col)) return false;
        Entity newEntity = type.create(row, col);
        grid[row][col] = newEntity;
        return true;
    }

    // Видалення об'єкта з клітинки
     public void removeEntityAt(int row, int col) {
        if (isInBounds(row, col)) {
            grid[row][col] = null;
        }
    }
}

