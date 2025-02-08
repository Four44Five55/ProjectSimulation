package org.example;

import org.example.abstracts.Action;
import org.example.actions.AddRandomEntity;
import org.example.actions.MakeMoveAll;
import org.example.model.SimulationMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private int counterTurns;
    SimulationMap simulationMap= new SimulationMap();
    MapConsoleRenderer renderer=new MapConsoleRenderer();
    private ArrayList<Action> initActions=new ArrayList<>();
    ArrayList<Action> turnActions=new ArrayList<>();

    public Simulation() {

    }

    public int getCounterTurns() {
        return counterTurns;
    }
    public ArrayList<Action> getTurnActions() {
        //ArrayList<Action> initActions=new ArrayList<>();
        turnActions.add(new MakeMoveAll(simulationMap));
        return turnActions;
    }

    public ArrayList<Action> getInitActions() {
        //ArrayList<Action> initActions=new ArrayList<>();
        initActions.add(new AddRandomEntity(simulationMap));
        return initActions;
    }

    public void render() {
        renderer.render(simulationMap);
    }


}
