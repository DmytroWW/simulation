package org.app;

import org.app.actions.InitActions;
import org.app.simulation.Map;
import org.app.simulation.Renderer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        InitActions.spawnAllEntities(map);
        Renderer.printMap(map);
    }
}