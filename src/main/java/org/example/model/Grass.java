package org.example.model;

import org.example.abstracts.Entity;

public class Grass extends Entity {
    private int HP = 10;

    public Grass(Cell cell) {
        super(cell, ANSI_GRASS);
    }

    public Grass() {
        super(ANSI_GRASS);
    }

    public void takeDamage(int damage) {
        this.HP -= damage;
    }
    public boolean isDead() {
        return this.HP <= 0;
    }
}
