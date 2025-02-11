package org.example.model;

import org.example.abstracts.Entity;

import java.util.HashMap;
import java.util.Random;

public class SimulationMap {
    private int counterTurns;
    private static int totalRows = 9;
    private static int totalColumns = 12;
    HashMap<Cell, Entity> map = new HashMap<>();
    public SimulationMap() {
    }
    public SimulationMap(int totalRows, int totalColumns) {
        SimulationMap.totalRows = totalRows;
        SimulationMap.totalColumns = totalColumns;
    }
    public HashMap<Cell, Entity> getMap() {
        return map;
    }

    public void setEntity(Cell cell, Entity entity) {
        entity.setCell(cell);
        map.put(cell, entity);
    }
    public void removeEntity(Cell cell) {
        if (map.containsKey(cell)) {
            map.remove(cell);
        } else {
            System.out.println("Key not found: " + cell);
        }
    }
    public void incrementCountTurns(){
        counterTurns++;
    }
    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public int getCounterTurns() {
        return counterTurns;
    }

    public Cell getRandomEmptyCell() {
        Cell cell = SimulationMap.getRandomCell();
        while (map.containsKey(cell)) {
            cell = SimulationMap.getRandomCell();
        }
        return cell;
    }

    public static Cell getRandomCell() {
        Random random = new Random();
        int row = random.nextInt(totalRows - 1) + 1;
        int column = random.nextInt(totalColumns - 1) + 1;
        return new Cell(row, column);
    }
}
