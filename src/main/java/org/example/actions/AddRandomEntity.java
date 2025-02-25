package org.example.actions;

import org.example.abstracts.Action;
import org.example.interfaces.AnsiInterface;
import org.example.interfaces.EnumEntitySpecies;
import org.example.model.*;

public class AddRandomEntity extends Action implements AnsiInterface {


    public AddRandomEntity(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    @Override
    public void makeTurn() {
        alignmentOfEntity();
    }

    private void alignmentOfEntity() {
        for (EnumEntitySpecies enumEntitySpecies : EnumEntitySpecies.values()) {
            for (int i = 1; i <= simulationMap.getCapacityOneEntity(); i++) {
                simulationMap.setEntity(simulationMap.getRandomEmptyCell(), createEntity(enumEntitySpecies));
            }
        }
    }

}
