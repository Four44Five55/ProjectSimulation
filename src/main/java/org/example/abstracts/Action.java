package org.example.abstracts;

import org.example.interfaces.ActionsInterface;
import org.example.interfaces.EnumEntitySpecies;
import org.example.model.*;

abstract public class Action implements ActionsInterface {
    protected SimulationMap simulationMap;

    public void makeTurn() throws InterruptedException {
    }

    public SimulationMap getSimulationMap() {
        return simulationMap;
    }

    public Entity createEntity(EnumEntitySpecies enumEntitySpecies) {
        switch (enumEntitySpecies) {
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
            default -> throw new IllegalArgumentException("Неизвестный тип сущности: " + enumEntitySpecies);
        }
    }
}
