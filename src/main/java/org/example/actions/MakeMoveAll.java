package org.example.actions;

import org.example.abstracts.Action;
import org.example.abstracts.Creature;
import org.example.abstracts.Entity;
import org.example.interfaces.AnsiInterface;
import org.example.model.Cell;
import org.example.model.SimulationMap;

import java.util.*;

public class MakeMoveAll extends Action implements AnsiInterface {
    SimulationMap simulationMap;

    public MakeMoveAll(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    @Override
    public void makeTurn() throws InterruptedException {
        List<Creature> creatureArrayList = new ArrayList<>();
        Map<Cell, Entity> mapCopy = new HashMap<>(simulationMap.getMap()); // Создаем копию map

        for (Map.Entry<Cell, Entity> entry : mapCopy.entrySet()) {
            if (ANSI_PREDATOR.equals(entry.getValue().getName()) || ANSI_HERBIVORE.equals(entry.getValue().getName())) {
                creatureArrayList.add((Creature) entry.getValue());
            }
        }

        for (Creature creature : creatureArrayList) {
            if (simulationMap.getMap().containsKey(creature.getCell())) {
                creature.makeMove(simulationMap);
            }

        }
    }
}
