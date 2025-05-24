package org.app.actions;

import org.app.Config;
import org.app.EntityType;
import org.app.entity.Entity;
import org.app.simulation.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.app.actions.Actions.createEntity;

// Клас з методами які відповідають за стартове наповнення.

public class InitActions {

    //Метод наповнює стартову карту об'єктами.

    public static boolean spawnEntitiesOnMap(EntityType type, int count, Map map){

        List<int[]> coordinates = generateShuffledCoordinates(Config.MAP_HEIGHT, Config.MAP_WIDTH);
        int placed = 0;

        for (int[] coord : coordinates) {
            int row = coord[0];
            int col = coord[1];

                Entity entity = createEntity(type, row, col);
                if (map.placeEntityAt(entity, row, col)) {
                    placed++;
                    if (placed == count) break;
                }

        }
        return placed == count;
    }

    // Метод який створює масив випадкових чисел від 0 до максимального значення.

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




}


