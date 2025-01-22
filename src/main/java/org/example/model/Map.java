package org.example.model;

import org.example.abstracts.Entity;
import org.example.interfaces.EntityInterface;

import java.util.HashMap;

public class Map {
    private  int totalRows=12;
    private int totalColumns=18;
    HashMap<Cell, Entity> map=new HashMap<>();

    public Map(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
    }

    public Map() {
    }

    public HashMap<Cell, Entity> getMap() {
        return map;
    }

    public void setEntity(Cell cell, Entity entity){
        entity.cell=cell;
        map.put(cell,entity);
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }
}
