package org.example.actions;

import org.example.abstracts.Action;
import org.example.abstracts.Entity;
import org.example.interfaces.AnsiInterface;
import org.example.interfaces.EnumEntity;
import org.example.model.*;

public class AddRandomEntity extends Action implements AnsiInterface {
    final double TOTAL_PERCENT_CAPACITY_ENTITY = 0.3;
    final double TOTAL_ENTITY = 5;

    String name;

    public AddRandomEntity(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    @Override
    public void makeTurn() {
        alignmentOfEntity();
    }

    public static Entity createEntity(EnumEntity enumEntity) {
        switch (enumEntity) {
            case ROCK -> {
                return new Rock();
            }
            case TREE -> {
                return new Tree();
            }
            case GRASS -> {
                return new Grass();
            }
            case PREDATOR -> {
                return new Predator();
            }
            case HERBIVORE -> {
                return new Herbivore();
            }
            default -> throw new IllegalArgumentException("Unknown entity type: " + enumEntity);
        }
    }

    private void alignmentOfEntity() {
        int numberOfEntity = (int) Math.round(TOTAL_PERCENT_CAPACITY_ENTITY / TOTAL_ENTITY * simulationMap.getTotalRows() * simulationMap.getTotalColumns());
        for (EnumEntity enumEntity : EnumEntity.values()) {
            for (int i = 1; i <= numberOfEntity; i++) {
                simulationMap.setEntity(simulationMap.getRandomEmptyCell(), createEntity(enumEntity));
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
