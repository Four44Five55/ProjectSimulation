package org.example;

import org.example.interfaces.AnsiInterface;
import org.example.model.Cell;
import org.example.model.SimulationMap;

public class MapConsoleRenderer implements AnsiInterface {


    public void render(SimulationMap simulationMap) {
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
    }
}
