package org.app.simulation;

import org.app.entity.Entity;
import org.app.entity.creature.Creature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation {

    private final GameMap map;

    // Конструктор
    public Simulation(GameMap map) {
        this.map = map;
    }

    // Метод для запуску 1 ходу всіх істот у випадковому порядку
    public void runTurn() {
        List<Creature> creatures = new ArrayList<>();

        // Обходимо карту та додаємо всі живі істоти
        for (int row = 0; row < map.getHeight(); row++) {
            for (int col = 0; col < map.getWidth(); col++) {
                Entity entity = map.getEntityAt(row, col);
                if (entity instanceof Creature creature) {
                    creatures.add(creature);
                }
            }
        }

        // Перемішуємо список істот
        Collections.shuffle(creatures);

        // Запускаємо хід для кожної істоти
        for (Creature creature : creatures) {
            creature.makeMove();
        }
    }
}
