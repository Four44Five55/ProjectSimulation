package org.example;

import org.example.abstracts.Action;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Simulation simulation = new Simulation();

        Iterator<Action> initAction = simulation.getInitActions().iterator();
        while (initAction.hasNext()) {
            initAction.next().makeTurn();
        }
        simulation.render();


        for (int i=1;i<=10;i++){
            Iterator<Action> turnAction = simulation.getTurnActions().iterator();
            while (turnAction.hasNext()) {
                turnAction.next().makeTurn();
                simulation.simulationMap.incrementCountTurns();
                simulation.render();
            }


        }


        System.out.println("==================");
    }
}
