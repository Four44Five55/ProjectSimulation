package org.example.model;

import org.example.abstracts.Entity;
import org.example.interfaces.EnumEntitySpecies;

public class Rock extends Entity {

    public Rock(Cell cell) {
        super(cell, ANSI_ROCK, EnumEntitySpecies.ROCK);
    }

    public Rock() {
        super(ANSI_ROCK, EnumEntitySpecies.ROCK);
    }


}
