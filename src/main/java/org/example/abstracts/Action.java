package org.example.abstracts;

import org.example.Simulation;
import org.example.interfaces.ActionsInterface;
import org.example.model.SimulationMap;

abstract public class Action implements ActionsInterface {
    protected SimulationMap simulationMap;
    public void makeTurn(){}

    public SimulationMap getSimulationMap() {
        return simulationMap;
    }
}
