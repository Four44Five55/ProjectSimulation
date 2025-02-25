package org.example;

import org.example.abstracts.Action;
import org.example.actions.AddRandomEntity;
import org.example.actions.MakeMoveAll;
import org.example.actions.MapConsoleRenderer;
import org.example.actions.SpawnEntity;
import org.example.model.SimulationMap;

import java.util.ArrayList;

public class Simulation {

    SimulationMap simulationMap = new SimulationMap();
    private ArrayList<Action> initActions = new ArrayList<>();
    ArrayList<Action> turnActions = new ArrayList<>();

    public Simulation() {

    }

    public ArrayList<Action> getTurnActions() {
        turnActions.add(new MakeMoveAll(simulationMap));
        turnActions.add(new SpawnEntity(simulationMap));
        return turnActions;
    }

    public ArrayList<Action> getInitActions() {
        initActions.add(new AddRandomEntity(simulationMap));
        return initActions;
    }

}
