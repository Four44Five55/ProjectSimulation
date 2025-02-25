package org.example;

import org.example.abstracts.Action;
import org.example.actions.MapConsoleRenderer;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Simulation simulation = new Simulation();

        Iterator<Action> initAction = simulation.getInitActions().iterator();
        while (initAction.hasNext()) {
            initAction.next().makeTurn();
        }
        MapConsoleRenderer.render(simulation.simulationMap);


        for (int i = 1; i <= 5; i++) {
            Iterator<Action> turnAction = simulation.getTurnActions().iterator();
            while (turnAction.hasNext()) {
                turnAction.next().makeTurn();
            }
            //simulation.simulationMap.incrementCountTurns();
            //simulation.render();

        }


        System.out.println("==================");
    }
}
