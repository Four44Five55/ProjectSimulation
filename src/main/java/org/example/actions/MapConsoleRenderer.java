package org.example.actions;

import org.example.interfaces.AnsiInterface;
import org.example.model.Cell;
import org.example.model.SimulationMap;

public class MapConsoleRenderer implements AnsiInterface {
    public static void render(SimulationMap simulationMap) throws InterruptedException {
        if (simulationMap.getCounterTurns() < 1) {
            System.out.println("Карта создана.");
        } else {
            System.out.printf("Выполнение %d хода.", simulationMap.getCounterTurns());
            System.out.println();
        }
        String line = "";
        for (int row = 1; row <= simulationMap.getTotalRows(); row++) {
            for (int column = 1; column <= simulationMap.getTotalColumns(); column++) {
                Cell cell = new Cell(row, column);
                if (simulationMap.getMap().containsKey(cell)) {
                    line += simulationMap.getMap().get(cell).getName();
                } else {
                    line += ANSI_EMPTY;
                }
            }
            System.out.println(line + ANSI_RESET);

            line = "";
        }
        simulationMap.incrementCountTurns();
        Thread.sleep(2500);
    }
}
