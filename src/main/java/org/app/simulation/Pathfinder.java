package org.app.simulation;

import org.app.simulation.GameMap;
import org.app.model.DietType;
import org.app.entity.Entity;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Queue;

import static org.app.Config.MAP_HEIGHT;
import static org.app.Config.MAP_WIDTH;

/*
* > Pathfinder.findNextStepToNearestPrey(startRow, startCol, dietType)
├─> Pathfinder.findNearestPrey(startRow, startCol, dietType) – шукає координати жертви
└─> Pathfinder.computeNextStepTowards(startRow, startCol, preyRow, preyCol, dietType) – повертає один крок до жертви
*  */


public class Pathfinder {
    private final GameMap map;

    // Стовпець «напрямків»
    private static final int[][] DIRECTIONS = {
            {-1, 0},  // вверх
            {1, 0},   // вниз
            {0, -1},  // вліво
            {0, 1}    // вправо
    };

    public Pathfinder(GameMap map) {
        this.map = map;
    }

    public GameMap getMap() {
        return map;
    }

    /**
     * Знаходить найближчу «їстівну» істоту від координат (startRow, startCol).
     * Повертає Point із координатами жертви, або null, якщо не знайдено жодної.
     */
    public Point findNearestPrey(int startRow, int startCol, DietType dietType) {
        int HEIGHT = MAP_HEIGHT;
        int WIDTH  = MAP_WIDTH;

        boolean[][] visited = new boolean[HEIGHT][WIDTH];
        Queue<Point> queue = new ArrayDeque<>();

        // Додаємо стартову точку
        queue.add(new Point(startRow, startCol));
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int r = cur.x, c = cur.y;

            for (int[] dir : DIRECTIONS) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (!map.isInBounds(nr, nc) || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;

                Entity neighbor = map.getEntityAt(nr, nc);
                if (neighbor != null) {
                    // Якщо це «їстівна» істота
                    if (dietType.canEat(neighbor.getType())) {
                        return new Point(nr, nc);
                    }
                    // Якщо неїстівна – все одно додаємо клітинку в чергу,
                    // щоб мати змогу продовжити BFS «за обходом».
                }
                // Якщо null (порожня клітинка) – теж додаємо
                queue.add(new Point(nr, nc));
            }
        }

        return null; // нічого не знайдено
    }

    /**
     * Будує шлях (через масив parent) від (startRow,startCol) до (targetRow,targetCol),
     * враховуючи, що «перешкоди» = неїстівні істоти. Повертає лише
     * першу клітинку шляху (тобто «крок» із (startRow,startCol)).
     * Якщо шляху не існує – повертає null.
     */
    public Point computeNextStepTowards(
            int startRow,
            int startCol,
            int targetRow,
            int targetCol,
            DietType dietType) {

        // Отримуємо розміри мапи
        int mapHeight = MAP_HEIGHT;
        int mapWidth = MAP_WIDTH;

        // Масив для відмітки вже відвіданих клітинок
        boolean[][] visitedCells = new boolean[mapHeight][mapWidth];

        // Масив, який зберігає "батьківську" клітинку — звідки ми прийшли
        Point[][] parentCell = new Point[mapHeight][mapWidth];

        // Черга для BFS — ширинного обходу
        Queue<Point> bfsQueue = new ArrayDeque<>();

        // Додаємо стартову клітинку до черги
        bfsQueue.add(new Point(startRow, startCol));
        visitedCells[startRow][startCol] = true;
        parentCell[startRow][startCol] = null; // Старт не має батьківської клітинки

        // Запускаємо BFS для пошуку шляху
        while (!bfsQueue.isEmpty()) {
            Point current = bfsQueue.poll();
            int currentRow = current.x;
            int currentCol = current.y;

            // Якщо поточна клітинка — це ціль (жертва), починаємо відновлення шляху
            if (currentRow == targetRow && currentCol == targetCol) {
                Point step = current;
                Point previous = parentCell[step.x][step.y];

                // Проходимо вгору по ланцюгу батьків, поки не дійдемо до старту
                while (previous != null &&
                        !(previous.x == startRow && previous.y == startCol)) {
                    step = previous;
                    previous = parentCell[step.x][step.y];
                }

                // Повертаємо першу клітинку, куди слід зробити крок
                return step;
            }

            // Проходимо по всіх сусідніх клітинках (вверх, вниз, вліво, вправо)
            for (int[] direction : DIRECTIONS) {
                int neighborRow = currentRow + direction[0];
                int neighborCol = currentCol + direction[1];

                // Пропускаємо клітинки, що поза межами карти
                if (!map.isInBounds(neighborRow, neighborCol)) {
                    continue;
                }

                // Пропускаємо вже відвідані клітинки
                if (visitedCells[neighborRow][neighborCol]) {
                    continue;
                }

                // Отримуємо сутність (істоту), що знаходиться в сусідній клітинці
                Entity neighborEntity = map.getEntityAt(neighborRow, neighborCol);

                // Якщо ця істота існує, але не може бути з'їдена — не проходимо
                if (neighborEntity != null &&
                        !dietType.canEat(neighborEntity.getType())) {
                    continue;
                }

                // Якщо все добре — відмічаємо клітинку як відвідану
                visitedCells[neighborRow][neighborCol] = true;

                // Зберігаємо, з якої клітинки ми сюди прийшли
                parentCell[neighborRow][neighborCol] = new Point(currentRow, currentCol);

                // Додаємо клітинку в чергу для подальшого обходу
                bfsQueue.add(new Point(neighborRow, neighborCol));
            }
        }

        // Якщо ми не знайшли шлях до цілі — повертаємо null
        return null;
    }

    /**
     * Обгортка: одночасно знайти жертву та отримати «перший крок» до неї.
     * Повертає null, якщо:
     *  1. не знайдено жодної їстівної істоти; або
     *  2. знайдено, але шляху до неї (через порожні клітинки або прохідні об’єкти) не існує.
     */
    public Point findNextStepToNearestPrey(int startRow, int startCol, DietType dietType) {
        Point prey = findNearestPrey(startRow, startCol, dietType);
        if (prey == null) return null;
        return computeNextStepTowards(startRow, startCol, prey.x, prey.y, dietType);
    }
}
