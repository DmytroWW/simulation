package org.app.simulation;

import org.app.Config;
import org.app.entity.Entity;

public class Map {
    // Поле. Двовимірний масив що представляє карту.
    private Entity[][] grid;

    // Конструктор класу Мар.
    public Map() {

        grid = new Entity[Config.MAP_HEIGHT][Config.MAP_WIDTH];
    }

    // Методи класу Мар.

    // Перевірка чи координати в межах карти.
    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < Config.MAP_HEIGHT && col >= 0 && col < Config.MAP_WIDTH;
    }

    // Перевірка чи вільна клітинка.
    public boolean isCellEmpty(int row, int col) {
        return isInBounds(row, col) && grid[col][row] == null;
    }

    // Повертає об'єкт який знаходиться в клітинці
    public Entity getEntityAt(int row, int col) {
        if (!isInBounds(row, col)) return null;
        return grid[row][col];
    }

    // Кладемо об'єкт в клітинку
    public boolean placeEntityAt(Entity entity, int row, int col) {
        if (!isCellEmpty(row, col)) return false;
        grid[row][col] = entity;
        entity.row = row;
        entity.col = col;
        return true;
    }

    // Видалення об'єкта з клітинки
     public void removeEntityAt(int row, int col) {
        if (isInBounds(row, col)) {
            grid[row][col] = null;
        }
    }
}

