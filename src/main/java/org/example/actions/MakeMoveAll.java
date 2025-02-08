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
        Map<Cell, Entity> changes = new HashMap<>();
        Iterator<Map.Entry<Cell, Entity>> iterator = simulationMap.getMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Cell, Entity> entry = iterator.next();
            if (ANSI_PREDATOR.equals(entry.getValue().getName()) || ANSI_HERBIVORE.equals(entry.getValue().getName())) {
                Creature creature = (Creature) entry.getValue();
                creature.updateListNearEmptyCell(simulationMap);

                Cell newCell = getRandomCellFromList(creature.getListNearEmptyCell());
                if (newCell != null) {
                    changes.put(newCell, creature); // Добавляем на новую клетку
                    iterator.remove(); // Удаляем со старой клетки
                }
            }
        }

        simulationMap.getMap().putAll(changes);
    }



    @Override
    public String getName() {
        return name;
    }

    private Cell getRandomCellFromList(ArrayList<Cell> cellArrayList) {
        Random randomizer = new Random();
        return cellArrayList.get(randomizer.nextInt(cellArrayList.size()));
    }


}
