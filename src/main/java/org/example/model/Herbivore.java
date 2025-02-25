package org.example.model;

import org.example.abstracts.Creature;
import org.example.interfaces.CreatureConstantsInterface;
import org.example.interfaces.EnumEntitySpecies;

public class Herbivore extends Creature implements CreatureConstantsInterface {

    public Herbivore() {
        super(ANSI_HERBIVORE,
                EnumEntitySpecies.HERBIVORE,
                SPEED_HERBIVORE,
                HP_HERBIVORE,
                RANGE_VISION_HERBIVORE,
                ANSI_GRASS,
                POWER_ATTACK_HERBIVORE);
    }
}
