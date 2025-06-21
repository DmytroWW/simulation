package org.app.simulation;

import org.app.Config;
import org.app.model.EntityType;
import org.app.entity.Entity;
import org.app.factory.EntityFactory;
import org.app.simulation.Pathfinder;

public class GameMap {
    // Поле. Двовимірний масив що представляє карту.
    private final Entity[][] grid;
    // Єдиний екземпляр Pathfinder для цієї карти
    private final Pathfinder pathfinder;

    // Конструктор класу.
    public GameMap() {
        grid = new Entity[Config.MAP_HEIGHT][Config.MAP_WIDTH];
        pathfinder = new Pathfinder(this);
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

    // Повертає об'єкт який знаходиться в клітинці.
    public Entity getEntityAt(int row, int col) {
        if (!isInBounds(row, col)) return null;
        return grid[row][col];
    }

    // Кладе новий екземпляр об'єкта в клітинку.
    public boolean PlaceEntityAt(EntityType type, int row, int col) {
        if (!isInBounds(row, col) || !isCellEmpty(row, col)) return false;
        Entity newEntity = EntityFactory.create(type, row, col, pathfinder);
        grid[row][col] = newEntity;
        return true;
    }

    // Видалення об'єкта з клітинки.
     public void removeEntityAt(int row, int col) {
        if (isInBounds(row, col)) {
            grid[row][col] = null;
        }
    }

    // Гетер пасфайндера.
    public Pathfinder getPathfinder() {
        return pathfinder;
    }

    // Переміщення істоти
    public boolean moveEntity(int fromRow, int fromCol, int toRow, int toCol) {
        if (!isInBounds(toRow, toCol) || grid[fromRow][fromCol] == null) {
            return false;
        }

        Entity entity = grid[fromRow][fromCol];
        grid[fromRow][fromCol] = null;
        entity.setRow(toRow);
        entity.setCol(toCol);
        grid[toRow][toCol] = entity;
        return true;
    }
}

