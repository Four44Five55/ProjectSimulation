package org.example.actions;

import org.example.abstracts.Action;
import org.example.model.Cell;
import org.example.model.Grass;
import org.example.model.Map;

import java.util.Random;

public class AddRandomEntity extends Action {
    final double TOTAL_PERCENT_CAPACITY_ENTITY = 0.3;
    final double TOTAL_ENTITY = 6;

    String name;

    Map map = new Map();

    public AddRandomEntity(Map map) {
        this.map = map;
    }

    public void alignmentOfEntity() {
        int numberOfEntity = (int) Math.round(TOTAL_PERCENT_CAPACITY_ENTITY / TOTAL_ENTITY * map.getTotalRows() * map.getTotalColumns());
        Random randomRow = new Random();
        Random randomColumn = new Random();
        for (int i = 1; i <= numberOfEntity; i++) {
            int row = randomRow.nextInt(map.getTotalRows() - 1) + 1;
            int column = randomColumn.nextInt(map.getTotalColumns() - 1) + 1;
            Cell cell = new Cell(row, column);

            if (!map.getMap().containsKey(cell)) {
                map.setEntity(cell, new Grass());
            }
        }

    }

    @Override
    public Map getMap() {
        return map;
    }

    @Override
    public String getName() {
        return name;
    }
}
