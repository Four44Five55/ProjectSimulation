package org.example.model;

import org.example.abstracts.Creature;
import org.example.interfaces.CreatureConstantsInterface;

import java.util.ArrayList;

public class Herbivore extends Creature implements CreatureConstantsInterface {

    public Herbivore() {
        super(ANSI_HERBIVORE, SPEED_HERBIVORE, HP_HERBIVORE);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void getListNearEmptyCell(Map map) {
        super.getListNearEmptyCell(map);
    }
}
