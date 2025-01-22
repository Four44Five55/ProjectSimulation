package org.example.model;

import org.example.abstracts.Entity;

public class Rock extends Entity {

    public Rock(Cell cell) {
        super(cell, ANSI_ROCK);
    }

    public Rock() {
        super(ANSI_ROCK);
    }
}
