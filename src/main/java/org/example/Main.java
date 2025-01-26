package org.example;

import org.example.interfaces.EntityInterface;
import org.example.model.*;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Map map=new Map();

        map.setEntity(new Cell(1,1),new Rock());
        map.setEntity(new Cell(1,2),new Grass());
        map.setEntity(new Cell(5,7),new Predator());
        map.setEntity(new Cell(11,13),new Herbivore());

        MapConsoleRenderer renderer=new MapConsoleRenderer();
        renderer.render(map);
        System.out.println(" ");







    }


}