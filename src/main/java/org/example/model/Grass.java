package org.example.model;

import org.example.abstracts.Entity;

public class Grass extends Entity {
    public Grass(Cell cell) {
        super(cell, "Т");
    }

    public Grass() {
        super("Т");
    }
}
