package org.app;

import org.app.simulation.actions.InitActions;
import org.app.simulation.GameMap;
import org.app.simulation.Renderer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameMap map = new GameMap();
        InitActions.spawnAllEntities(map);
        Renderer.printMap(map);
    }
}