package org.example;

import org.example.abstracts.Action;
import org.example.abstracts.Entity;
import org.example.actions.AddRandomEntity;
import org.example.interfaces.AnsiInterface;
import org.example.model.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Simulation simulation = new Simulation();
        simulation.render();
        Iterator<Action> initAction = simulation.getInitActions().iterator();
        while (initAction.hasNext()) {
            initAction.next().makeTurn();
        }
        System.out.println("==================");
        simulation.render();
        System.out.println("==================");
        Iterator<Action> turnAction = simulation.getTurnActions().iterator();
        while (turnAction.hasNext()) {
            turnAction.next().makeTurn();
        }
        simulation.render();

        System.out.println(" ");

        System.out.println(" ");

    }
}
