package org.app;

import org.app.simulation.Simulation;
import org.app.simulation.actions.InitActions;
import org.app.simulation.GameMap;
import org.app.simulation.Renderer;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameMap map = new GameMap();
        InitActions.spawnAllEntities(map);
        Simulation simulation = new Simulation(map);

        MAIN_MENU:
        while (true) {
            System.out.println("\n=== Головне меню ===");
            System.out.println("1 - Один крок симуляції");
            System.out.println("2 - Безкінечна симуляція");
            System.out.println("3 - Нова симуляція");
            System.out.println("4 - Вихід");
            System.out.print("Введи 1, 2, 3 або 4: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.println("\n=== Режим покрокової симуляції ===");
                    STEP_LOOP:
                    while (true) {
                        System.out.println("Поточний стан карти:");
                        Renderer.printMap(map);
                        System.out.println("Натисни Enter для наступного ходу, 'm' — повернутися в меню.");
                        String cmd = scanner.nextLine().trim();
                        if (cmd.equalsIgnoreCase("m")) {
                            break STEP_LOOP;
                        }
                        simulation.runTurn();
                    }
                }
                case "2" -> {
                    System.out.println("\n=== Безкінечна симуляція (Ctrl+C для зупинки) ===");
                    System.out.println("Початковий стан карти:");
                    Renderer.printMap(map);
                    while (true) {
                        simulation.runTurn();
                        System.out.println("Стан карти після ходу:");
                        Renderer.printMap(map);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            break MAIN_MENU;
                        }
                    }
                }
                case "3" -> {
                    System.out.println("\n=== Нова симуляція ===");
                    map = new GameMap();
                    InitActions.spawnAllEntities(map);
                    simulation = new Simulation(map);
                    System.out.println("Створено нову карту. Повернення в меню.");
                }
                case "4" -> {
                    System.out.println("Вихід з програми. До побачення!");
                    break MAIN_MENU;
                }
                default -> System.out.println("Невірний вибір, спробуй ще раз.");
            }
        }
    }
}