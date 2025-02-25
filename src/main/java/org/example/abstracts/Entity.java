package org.example.abstracts;

import org.example.interfaces.AnsiInterface;
import org.example.interfaces.EntityInterface;
import org.example.interfaces.EnumEntitySpecies;
import org.example.model.Cell;

import java.util.Objects;

public abstract class Entity implements EntityInterface, AnsiInterface {
    protected Cell cell;
    protected String name;
    protected EnumEntitySpecies enumEntitySpecies;

    public Entity(Cell cell, String name, EnumEntitySpecies enumEntitySpecies) {
        this.cell = cell;
        this.name = name;
        this.enumEntitySpecies = enumEntitySpecies;
    }

    public Entity() {
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Entity(String name, EnumEntitySpecies enumEntitySpecies) {
        this.name = name;
        this.enumEntitySpecies = enumEntitySpecies;
    }

    @Override
    public Cell getCell() {
        return cell;
    }

    @Override
    public String getName() {
        return name;
    }

    public EnumEntitySpecies getEnumEntitySpecies() {
        return enumEntitySpecies;
    }

    @Override
    public String toString() {
        return name;
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
