package org.example;

import org.example.interfaces.EntityInterface;
import org.example.model.*;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
    /*    Map map=new Map();

       *//* map.setEntity(new Cell(1,1),new Rock());
        map.setEntity(new Cell(1,2),new Grass());*//*
        MapConsoleRenderer renderer=new MapConsoleRenderer();
        renderer.render(map);
        System.out.println(" ");*/
        final String ANSI_RESET="\u001b[0m";
        final String ANSI_WHITE_SQUARE_BACKGROUND="\u001b[48;5;247m";
        final String ANSI_RED_SQUARE_BACKGROUND="\u001b[48;5;9m"+" \uD83D\uDC3A";
        final String ANSI_GREEN_SQUARE_BACKGROUND="\u001b[48;5;40m";
        final String ANSI_PINK_SQUARE_BACKGROUND="\u001b[48;5;213m";
        final String ANSI_YELLOW_SQUARE_BACKGROUND="\u001b[48;5;94m";

        System.out.println(
                ANSI_WHITE_SQUARE_BACKGROUND+"   "+
                ANSI_RED_SQUARE_BACKGROUND+
                ANSI_GREEN_SQUARE_BACKGROUND+" \uD83C\uDF33"+
                ANSI_PINK_SQUARE_BACKGROUND+" \uD83D\uDC11"+
                ANSI_YELLOW_SQUARE_BACKGROUND+" \uD83E\uDDF1"+ANSI_RESET);
    }


}