package org.example.model;

import org.example.abstracts.Creature;
import org.example.interfaces.CreatureConstantsInterface;

public class Herbivore extends Creature implements CreatureConstantsInterface {

    public Herbivore() {
        super(ANSI_HERBIVORE, SPEED_HERBIVORE, HP_HERBIVORE);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void updateListNearEmptyCell(SimulationMap simulationMap) {
        super.updateListNearEmptyCell(simulationMap);
    }
}
