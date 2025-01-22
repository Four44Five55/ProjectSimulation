package org.example.abstracts;

import org.example.interfaces.EntityInterface;
import org.example.model.Cell;

public abstract class Entity implements EntityInterface {
    public Cell cell;
    public  String name;
    public Entity(Cell cell, String name) {
        this.cell = cell;
        this.name = name;
    }

    public Entity() {
    }

    public Entity(String name) {
        this.name = name;
    }

    public Cell getCell() {
        return cell;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "cell=" + cell +
                ", name='" + name + '\'' +
                '}';
    }
}
