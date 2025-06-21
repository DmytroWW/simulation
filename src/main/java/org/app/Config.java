package org.app;

public class Config {
    //розміри поля
    public static final int MAP_WIDTH = 15;
    public static final int MAP_HEIGHT = 15;

    //кількість істот
    public static final int INITIAL_HERBIVORES_COUNT = 25;
    public static final int INITIAL_PREDATORS_COUNT = 7;
    public static final int INITIAL_GRASS_COUNT = 35;
    public static final int INITIAL_ROCKS_COUNT = 15;
    public static final int INITIAL_TREES_COUNT = 10;

    //атака\здоров'я істот
    public static final int PREDATOR_ATTACK_POWER = 10;
    public static final int HERBIVORE_ATTACK_POWER = 10;

    public static final int PREDATOR_MAX_HEALTH = 20;
    public static final int HERBIVORE_MAX_HEALTH = 20;
    public static final int GRASS_MAX_HEALTH = 10;

    //швидкість істот
    public static final int HERBIVORE_SPEED = 1;
    public static final int PREDATOR_SPEED = 1;

    //голод
    public static final int PREDATOR_HEALTH_RESTORE = 10;
    public static final int HERBIVORE_HEALTH_RESTORE = 10;

    public static final int HERBIVORE_HUNGER_THRESHOLD = 5;
    public static final int PREDATOR_HUNGER_THRESHOLD = 5;

    public static final int HERBIVORE_HUNGER_DAMAGE = 2;
    public static final int PREDATOR_HUNGER_DAMAGE = 2;

}
