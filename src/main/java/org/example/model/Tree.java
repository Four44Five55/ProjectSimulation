package org.example.model;

import org.example.abstracts.Entity;

public class Tree extends Entity {

    public Tree(Cell cell) {
        super(cell, ANSI_TREE);
    }

    public Tree() {
        super(ANSI_TREE);
    }
}
