package org.app.entity.creature;

import org.app.entity.Grass;
import org.app.model.DietType;
import org.app.model.EntityType;
import org.app.entity.Entity;
import org.app.simulation.GameMap;
import org.app.simulation.Pathfinder;

import java.awt.*;

public abstract class Creature extends Entity {
    // Поля
    protected int hp;
    protected int maxHp;
    protected int speed;
    protected final DietType dietType;
    protected final org.app.simulation.Pathfinder pathfinder;
    protected final GameMap map;

    // Голод
    protected int moveCount = 0;
    private final int hungerThreshold;
    private final int hungerDamage;

    // Конструктор
    public Creature (int row,
                     int col,
                     EntityType type,
                     int hp,
                     int speed,
                     DietType dietType,
                     Pathfinder pathfinder,
                     int hungerThreshold,
                     int hungerDamage
                     ) {
        super(row, col, type);
        this.hp = hp;
        this.speed = speed;
        this.dietType = dietType;
        this.pathfinder = pathfinder;
        this.map = pathfinder.getMap();
        this.moveCount = 0;
        this.hungerThreshold = hungerThreshold;
        this.hungerDamage = hungerDamage;
    }

    // Оверрайд методи

    @Override
    public abstract String render();


    // Методи
    public void takeDamage(int amount) {
        hp -= amount;
        if (hp <= 0) die();
    }

    protected void die() {
        map.removeEntityAt(getRow(), getCol());
    }


    public void makeMove() {
        // Ходи життя істоти
        moveCount++;
        if (moveCount >= hungerThreshold) {
            takeDamage(hungerDamage);
        }

        Point next = pathfinder.findNextStepToNearestPrey(getRow(), getCol(), dietType);
        if (next == null) return;

        int nr = next.x, nc = next.y;
        Entity target = map.getEntityAt(nr, nc);
        if (target != null && dietType.canEat(target.getType())) {
            attack(target);
        }
        map.moveEntity(getRow(), getCol(), nr, nc);
    }

    public void attack(Entity target) {
        int dmg = getAttackPower();
        target.takeDamage(dmg);

        if (target instanceof Creature) {
            Creature c = (Creature) target;
            if (c.hp <= 0) {
                c.die();
                this.onKill(c);
            }
        } else if (target instanceof Grass) {
            Grass g = (Grass) target;
            if (g.isDead()) {
                this.onEatGrass(g);
            }
        }
    }
    protected void onKill(Creature prey) {
        // За замовчуванням нічого
    }

    protected void onEatGrass(Grass grass) {
        // За замовчуванням нічого
    }

    public abstract int getAttackPower();




};
