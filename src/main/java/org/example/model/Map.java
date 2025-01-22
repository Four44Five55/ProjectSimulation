package org.example.model;

import org.example.abstracts.Entity;
import org.example.interfaces.EntityInterface;

import java.util.HashMap;

public class Map {
    HashMap<Cell, Entity> map=new HashMap<>();

    public void setEntity(Cell cell, Entity entity){
        entity.cell=cell;
        map.put(cell,entity);
    }




}
