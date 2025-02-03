package org.example;

import org.example.abstracts.Entity;
import org.example.actions.AddRandomEntity;
import org.example.interfaces.AnsiInterface;
import org.example.model.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Map map = new Map();
        AddRandomEntity addRandomEntity = new AddRandomEntity(map);
        addRandomEntity.alignmentOfEntity();
        MapConsoleRenderer renderer = new MapConsoleRenderer();
        renderer.render(map);


        for (java.util.Map.Entry<Cell, Entity> entry : map.getMap().entrySet()) {
            if (entry.getValue().getName().equals(AnsiInterface.ANSI_PREDATOR)) {
                Predator predator = (Predator) map.getMap().get(entry.getKey());
                predator.getListNearEmptyCell(map);
                Random randomizer = new Random();
                Cell randomCell = predator.getListNearEmptyCell().get(randomizer.nextInt(predator.getListNearEmptyCell().size()));
                predator.makeMove(randomCell,map);
                System.out.println(" ");
                renderer.render(map);
//              ArrayList<Cell> arrayList = entry.getListNearEmptyCell(map);

            }
        }


        System.out.println(" ");

        System.out.println(" ");

    }
}