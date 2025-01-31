package org.example;

import org.example.actions.AddRandomEntity;
import org.example.interfaces.EntityInterface;
import org.example.model.*;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        AddRandomEntity addRandomEntity = new AddRandomEntity(map);
        addRandomEntity.alignmentOfEntity();
        MapConsoleRenderer renderer = new MapConsoleRenderer();
        renderer.render(map);
        System.out.println(" ");

    }
}