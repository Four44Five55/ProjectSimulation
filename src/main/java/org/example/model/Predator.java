package org.example.model;

import org.example.abstracts.Creature;

public class Predator extends Creature {

    int speed=2;
    int HP=20;
    public Predator(int speed, int HP) {
        super(ANSI_PREDATOR,speed, HP);
    }

    public Predator(Cell cell, String name, int speed, int hp) {
        super(cell, name, speed, hp);
    }
}
