package org.example.model;

import org.example.abstracts.Entity;
import org.example.interfaces.EnumEntitySpecies;

public class Tree extends Entity {

    public Tree(Cell cell) {
        super(cell, ANSI_TREE, EnumEntitySpecies.TREE);
    }

    public Tree() {
        super(ANSI_TREE, EnumEntitySpecies.TREE);
    }
}
