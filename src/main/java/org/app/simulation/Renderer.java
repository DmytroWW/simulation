package org.app.simulation;

import org.app.Config;
import org.app.entity.Entity;

public class Renderer {
    public static void printMap(Map map) {
        for (int row = 0; row < Config.MAP_HEIGHT; row++) {
            for (int col = 0; col < Config.MAP_WIDTH; col++) {
                Entity e = map.getEntityAt(row, col);
                if (e == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(e.type.getSymbol() + " ");
                }
            }
            System.out.println();
        }
    }
}