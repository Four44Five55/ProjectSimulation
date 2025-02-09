package org.example.actions;

import org.example.abstracts.Action;
import org.example.abstracts.Creature;
import org.example.abstracts.Entity;
import org.example.interfaces.AnsiInterface;
import org.example.model.Cell;
import org.example.model.SimulationMap;

import java.util.*;

public class MakeMoveAll extends Action implements AnsiInterface {
    String name = "Движение всеми существами";
    SimulationMap simulationMap;

    public MakeMoveAll(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    @Override
    public void makeTurn() {
        List<Creature> creatureArrayList = new ArrayList<>();
        Iterator<Map.Entry<Cell, Entity>> iterator = simulationMap.getMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Cell, Entity> entry = iterator.next();
            if (ANSI_PREDATOR.equals(entry.getValue().getName()) || ANSI_HERBIVORE.equals(entry.getValue().getName())) {
                creatureArrayList.add((Creature) entry.getValue());
            }
        }
        for (Creature creature : creatureArrayList) {
            creature.makeMove(simulationMap);
        }
    }

    @Override
    public String getName() {
        return name;
    }


}
