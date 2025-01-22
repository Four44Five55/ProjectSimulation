package org.example.model;

import org.example.abstracts.Entity;

public class Rock extends Entity {

    public Rock(Cell cell) {
        super(cell, "К");
    }

    public Rock() {
        super("К");
    }
}
