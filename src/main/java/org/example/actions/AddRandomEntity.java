package org.example.actions;

import org.example.abstracts.Action;
import org.example.abstracts.Entity;
import org.example.interfaces.AnsiInterface;
import org.example.interfaces.EnumEntity;
import org.example.model.*;

import java.util.Random;

public class AddRandomEntity extends Action implements AnsiInterface {
    final double TOTAL_PERCENT_CAPACITY_ENTITY = 0.3;
    final double TOTAL_ENTITY = 5;

    String name;

    Map map;

    public AddRandomEntity(Map map) {
        this.map = map;
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

    public void alignmentOfEntity() {
        int numberOfEntity = (int) Math.round(TOTAL_PERCENT_CAPACITY_ENTITY / TOTAL_ENTITY * map.getTotalRows() * map.getTotalColumns());
        for (EnumEntity enumEntity : EnumEntity.values()) {
            for (int i = 1; i <= numberOfEntity; i++) {
                map.setEntity(map.getRandomEmptyCell(), createEntity(enumEntity));
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
