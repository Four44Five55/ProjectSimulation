package org.example;

import org.example.abstracts.Entity;
import org.example.interfaces.AnsiInterface;
import org.example.model.Cell;
import org.example.model.Map;

public class MapConsoleRenderer implements AnsiInterface {


    public void render(Map map) {
        String line = "";
        for (int row = 1; row <= map.getTotalRows(); row++) {
            for (int column = 1; column <= map.getTotalColumns(); column++) {
                Cell cell = new Cell(row, column);
                if (map.getMap().containsKey(cell)) {
                    line += map.getMap().get(cell).name;
                } else {
                    line += ANSI_EMPTY;
                }
            }
            System.out.println(line + ANSI_RESET);
            line="";
        }
    }


/*    private String colorizeCell(Map map, Cell cell) {

        Entity entity = map.getMap().get(cell);
        String result =switch (entity.name){
            case ANSI_GRASS -> ANSI_GRASS;
            case ANSI_HERBIVORE -> ANSI_HERBIVORE;
            case ANSI_PREDATOR -> ANSI_PREDATOR;
            case ANSI_ROCK -> ANSI_ROCK
        }

        return result;
        return null;
    }*/

/*    private String getEntityOrEmpty(Cell cell) {
        return " ";
    }*/

}
