package org.example.abstracts;

import org.example.interfaces.AnsiInterface;
import org.example.interfaces.EntityInterface;
import org.example.model.Cell;

import java.util.Objects;

public abstract class Entity implements EntityInterface, AnsiInterface {
    public Cell cell;
    public String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
