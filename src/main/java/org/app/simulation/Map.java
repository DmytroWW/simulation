package org.app.simulation;

import org.app.Config;
import org.app.entity.Entity;

public class Map {
    private Entity[][] grid;
    public Map() {
        grid = new Entity[Config.MAP_HEIGHT][Config.MAP_WIDTH];
    }
}

