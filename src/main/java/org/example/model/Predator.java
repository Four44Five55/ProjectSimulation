package org.example.model;

import org.example.abstracts.Creature;
import org.example.interfaces.CreatureConstantsInterface;
import org.example.interfaces.EnumEntitySpecies;

public class Predator extends Creature implements CreatureConstantsInterface {
    public Predator() {
        super(ANSI_PREDATOR,
                EnumEntitySpecies.PREDATOR,
                SPEED_PREDATOR,
                HP_PREDATOR,
                RANGE_VISION_PREDATOR,
                ANSI_HERBIVORE,
                POWER_ATTACK_PREDATOR);
    }
}
