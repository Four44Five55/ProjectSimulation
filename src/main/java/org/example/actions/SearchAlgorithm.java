package org.example.actions;

import org.example.model.Cell;
import org.example.model.SimulationMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static org.example.abstracts.Creature.correctIntSteppingOutside;

public class SearchAlgorithm {
    public static Map<Cell, Cell> breadthFirstSearch(Cell start, Cell target, SimulationMap simulationMap) {
        HashMap<Cell, Cell> visitedCells = new HashMap<>();
        Queue<Cell> queue = new LinkedList<>();
        //добавление начальной точки отсчета
        queue.add(start);
        visitedCells.put(start, null);

        while (!queue.isEmpty()) {
            Cell currentCell = queue.poll();

            // Если текущая ячейка — цель, завершаем поиск
            if (currentCell.equals(target)) {
                break;
            }

            //обход ячеек в зоне видимости и поиск пути до цели
            for (int row = -1; row <= 1; row++) {
                for (int column = -1; column <= 1; column++) {
                    int checkedRow = currentCell.getRow() + row;
                    int checkedColumn = currentCell.getColumn() + column;

                    Cell cell = new Cell(checkedRow + correctIntSteppingOutside(checkedRow, simulationMap.getTotalRows()),
                            checkedColumn + correctIntSteppingOutside(checkedColumn, simulationMap.getTotalColumns()));

                    if (cell.equals(target)) {
                        visitedCells.put(cell, currentCell);
                        return visitedCells;
                    }

                    if (!simulationMap.getMap().containsKey(cell)) {
                        if (!visitedCells.containsKey(cell)) {
                            queue.add(cell);
                            visitedCells.put(cell, currentCell);
                        }
                    }

                }
            }

        }
        return visitedCells;
    }
}
