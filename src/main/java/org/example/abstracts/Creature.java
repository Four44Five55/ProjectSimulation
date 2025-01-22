package org.example.abstracts;

import org.example.model.Cell;

abstract public class Creature extends  Entity{
    public final int speed;
    public final int HP;

    public Creature(int speed, int HP) {
        this.speed = speed;
        this.HP = HP;
    }

    public Creature(Cell cell, String name, int speed, int hp) {
        super(cell, name);
        this.speed = speed;
        this.HP = hp;
    }
    public void makeMove(){

    }
}
