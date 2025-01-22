package org.example.model;

import org.example.abstracts.Creature;

public class Herbivore extends Creature  {
     int speed=2;
     int HP=20;
    public Herbivore(int speed,int HP) {
        super(ANSI_HERBIVORE,speed,HP);
    }

    @Override
    public String toString() {
        return name;
    }
}
