package org.example.abstracts;

import org.example.model.Cell;

abstract public class Creature extends  Entity{
    public final int speed;
    public  int HP;

    public Creature(String name, int speed, int hp) {
        super(name);
        this.speed = speed;
        this.HP = hp;
    }

    public Creature(int speed, int HP) {
        this.speed = speed;
        this.HP = HP;
    }

    public Creature(Cell cell, String name, int speed, int hp) {
        super(cell, name);
        this.speed = speed;
        this.HP = hp;
    }
    public void makeMove(){

    }
    public void takeDamage(int damage){
        this.HP-=damage;
        if (this.HP<0){
            this.HP=0;
        }
    }
    public void heal(int amount){
        this.HP+=amount;
    }
}
