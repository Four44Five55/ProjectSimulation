package org.example.model;

import org.example.abstracts.Creature;

public class Herbivore extends Creature  {
     int speed=2;
     int HP=20;
    public Herbivore(Cell cell, int speed,int HP) {
        super(cell, ANSI_HERBIVORE,speed,HP);
    }

    @Override
    public String toString() {
        return name;
    }
}
