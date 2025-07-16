package org.app.simulation.actions;

import org.app.Config;
import org.app.model.EntityType;
import org.app.simulation.GameMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// Клас з методами які відповідають за стартове наповнення.

public class InitActions {

    //Метод наповнює стартову карту об'єктами.

    public static boolean spawnEntitiesOnMap(EntityType type, int count, GameMap map){

        List<int[]> coordinates = generateShuffledCoordinates(Config.MAP_HEIGHT, Config.MAP_WIDTH);
        int placed = 0;

        for (int[] coord : coordinates) {
            int row = coord[0];
            int col = coord[1];

                if (map.PlaceEntityAt(type, row, col)) {
                    placed++;
                    if (placed == count) {
                        break;
                    }
                }

        }
        return placed == count;
    }

    // Метод який створює масив випадкових координат.

    private static List<int[]> generateShuffledCoordinates(int height, int width){
        List<int[]> coords = new ArrayList<>();
        for (int row = 0; row <height; row++) {
            for (int col = 0; col < width; col++) {
                coords.add(new int[]{row, col});
            }
        }

        Collections.shuffle(coords);
        return coords;
    }

    public static void spawnAllEntities(GameMap map) {
        spawnEntitiesOnMap(EntityType.HERBIVORE, Config.INITIAL_HERBIVORES_COUNT, map);
        spawnEntitiesOnMap(EntityType.PREDATOR, Config.INITIAL_PREDATORS_COUNT, map);
        spawnEntitiesOnMap(EntityType.GRASS, Config.INITIAL_GRASS_COUNT, map);
        spawnEntitiesOnMap(EntityType.ROCK, Config.INITIAL_ROCKS_COUNT, map);
        spawnEntitiesOnMap(EntityType.TREE, Config.INITIAL_TREES_COUNT, map);
    }




}


