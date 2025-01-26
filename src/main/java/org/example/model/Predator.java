package org.example.model;

import org.example.abstracts.Creature;
import org.example.interfaces.CreatureConstantsInterface;

public class Predator extends Creature implements CreatureConstantsInterface {
    private int powerAttack=5;
    public Predator() {
        super(ANSI_PREDATOR, SPEED_PREDATOR, HP_PREDATOR);
    }

    public int getPowerAttack() {
        return powerAttack;
    }

    @Override
    public String toString() {
        return name;
    }
}
