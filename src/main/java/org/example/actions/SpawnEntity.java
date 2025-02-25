package org.example.actions;

import org.example.abstracts.Action;
import org.example.abstracts.Entity;
import org.example.interfaces.EnumEntitySpecies;
import org.example.model.SimulationMap;

import java.util.Map;
import java.util.stream.Collectors;

public class SpawnEntity extends Action {
    SimulationMap simulationMap;

    public SpawnEntity(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    @Override
    public void makeTurn() {
        Map<EnumEntitySpecies, Long> entityCounts = countEntity();
        entityCounts.forEach((entity, count) -> {
            if (count < simulationMap.getCapacityOneEntity()) {
                simulationMap.setEntity(simulationMap.getRandomEmptyCell(), createEntity(entity));
            }
        });
    }

    public Map<EnumEntitySpecies, Long> countEntity() {
        return this.simulationMap.getMap().values()
                .stream()
                .collect(Collectors.groupingBy(Entity::getEnumEntitySpecies, Collectors.counting()));
    }
}
