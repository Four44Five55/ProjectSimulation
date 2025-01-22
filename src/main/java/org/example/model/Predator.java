package org.example.model;

import org.example.abstracts.Creature;

public class Predator extends Creature {
    public Predator(int speed, int HP) {
        super(speed, HP);
    }

    public Predator(Cell cell, String name, int speed, int hp) {
        super(cell, name, speed, hp);
    }
}
