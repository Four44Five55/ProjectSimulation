package org.example.model;

import org.example.abstracts.Entity;

public class Grass extends Entity {
    public Grass(Cell cell) {
        super(cell, ANSI_GRASS);
    }

    public Grass() {
        super(ANSI_GRASS);
    }
}
