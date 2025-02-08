package org.example.model;

import org.example.abstracts.Entity;

import java.util.HashMap;
import java.util.Random;

public class SimulationMap {
    private static int totalRows = 9;
    private static int totalColumns = 12;
    HashMap<Cell, Entity> map = new HashMap<>();

    public SimulationMap(int totalRows, int totalColumns) {
        SimulationMap.totalRows = totalRows;
        SimulationMap.totalColumns = totalColumns;
    }

    public SimulationMap() {
    }

    public HashMap<Cell, Entity> getMap() {
        return map;
    }

    public void setEntity(Cell cell, Entity entity) {
        entity.setCell(cell);
        map.put(cell, entity);
    }

    /*  public Entity getEntity(Cell cell){
       }*/
    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
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
