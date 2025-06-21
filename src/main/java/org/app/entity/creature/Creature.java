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

    @Override
    public void takeDamage(int amount) {
        takeDamage(amount, "від голоду");
    }
    @Override
    public void takeDamage(int amount, String reason) {
        hp -= amount;
        if (hp <= 0) {
            System.out.printf("Я — %s. Помер %s на (%d,%d)%n",
                    this.getClass().getSimpleName(), reason, getRow(), getCol());
            die();
        }
    }
    // Методи

    public void makeMove() {
        int currentRow = getRow();
        int currentCol = getCol();
        // Ходи життя істоти
        moveCount++;
        if (moveCount >= hungerThreshold) {
            takeDamage(hungerDamage);
        }

        Point next = pathfinder.findNextStepToNearestPrey(getRow(), getCol(), dietType);
        if (next == null) {
            System.out.printf("Я — %s. Стою на місці (%d,%d), не знайшов куди йти.%n", this.getClass().getSimpleName(), currentRow, currentCol);
            return;
        }

        int nr = next.x, nc = next.y;

        Entity target = map.getEntityAt(nr, nc);

        if (target != null && dietType.canEat(target.getType())) {
            System.out.printf("Я — %s. Атакую %s на (%d,%d)%n", this.getClass().getSimpleName(), target.getType(), nr, nc);
            attack(target);

            if (target instanceof Creature c && c.hp > 0) {
                return;
            }
            if (target instanceof Grass g && !g.isDead()) {
                return;
            }

        }

        boolean moved = map.moveEntity(currentRow, currentCol, nr, nc);

        if (moved) {
            System.out.printf("Я — %s. Рухаюся з (%d,%d) в (%d,%d)%n", this.getClass().getSimpleName(), currentRow, currentCol, nr, nc);
        } else {
            System.out.printf("Я — %s. Не зміг рухатися з (%d,%d) в (%d,%d)%n", this.getClass().getSimpleName(), currentRow, currentCol, nr, nc);
        }

    }

    public void attack(Entity target) {
        int dmg = getAttackPower();
        target.takeDamage(dmg, "у бою");

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

    protected void die() {
        map.removeEntityAt(getRow(), getCol());
    }

    protected void onKill(Creature prey) {
        // За замовчуванням нічого
    }

    protected void onEatGrass(Grass grass) {
        // За замовчуванням нічого
    }

    public abstract int getAttackPower();




};
