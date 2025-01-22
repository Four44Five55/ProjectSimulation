package org.example;

import org.example.model.Cell;
import org.example.model.Map;

public class MapConsoleRenderer {
    public static final String ANSI_RESET="\u001b[0m";
    public static final String ANSI_WHITE_SQUARE_BACKGROUND="\u001B[37m";
    public static final String ANSI_RED_SQUARE_BACKGROUND="\u001b[48;5;9m";
    public static final String ANSI_GREEN_SQUARE_BACKGROUND="\u001b[48;5;40m";
    public static final String ANSI_PINK_SQUARE_BACKGROUND="\u001b[48;5;213m";
    public static final String ANSI_YELLOW_SQUARE_BACKGROUND="\u001b[48;5;213m";

    public void render(Map map){
        for (int row=1;row<=12;row++){
            String line=" ";
            for(int column=1;column<=12;column++){
                line=ANSI_WHITE_SQUARE_BACKGROUND+line;
            }
            System.out.println(line+ANSI_RESET);
        }
    }
    private String colorizeCell(Map map,Cell cell){
        String result="";

        return result;
    }
    private String getEntityOrEmpty(Cell cell)  {
        return " ";
    }

}
