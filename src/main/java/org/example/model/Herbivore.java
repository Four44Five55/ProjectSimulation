package org.example.model;

import org.example.abstracts.Creature;

public class Herbivore extends Creature  {

    public Herbivore(Cell cell) {
        super(cell, "Тр",2,20);
    }

    @Override
    public String toString() {
        return name;
    }
}
