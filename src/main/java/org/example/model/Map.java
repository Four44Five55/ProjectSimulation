package org.example.model;

import org.example.abstracts.Entity;
import org.example.interfaces.CellInterface;
import org.example.interfaces.EntityInterface;


import java.util.HashMap;
import java.util.Random;

public class Map {
    private static int totalRows = 3;
    private static int totalColumns = 6;
    HashMap<Cell, Entity> map = new HashMap<>();

    public Map(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
    }

    public Map() {
    }

    public HashMap<Cell, Entity> getMap() {
        return map;
    }

    public void setEntity(Cell cell, Entity entity) {
        entity.cell = cell;
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
        Cell cell = Map.getRandomCell();
        while (map.containsKey(cell)) {
            cell = Map.getRandomCell();
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
