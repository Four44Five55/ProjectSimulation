package org.example.abstracts;

import org.example.model.Cell;
import org.example.model.Map;

import java.util.ArrayList;

abstract public class Creature extends Entity {
    public final int speed;
    public int HP;
    ArrayList<Cell> listNearEmptyCell = new ArrayList<>();

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

    public void makeMove(Cell cell,Map map) {
        Cell deleteCell=this.cell;
        map.setEntity(cell, map.getMap().get(this.cell));
        map.getMap().remove(deleteCell);

        //this.cell = cell;
    }

    public void getListNearEmptyCell(Map map) {
        Cell creatureCell = this.cell;
        //ArrayList<Cell> arrayList = new ArrayList<>();
        int rangeOfVision = 1;
        for (int row = -rangeOfVision; row <= rangeOfVision; row++) {
            for (int column = -rangeOfVision; column <= rangeOfVision; column++) {
                int checkedRow = creatureCell.row + row;
                int checkedColumn = creatureCell.column + column;
                Cell cell = new Cell(checkedRow + correctIntSteppingOutside(checkedRow, map.getTotalRows()),
                        checkedColumn + correctIntSteppingOutside(checkedColumn, map.getTotalColumns()));
                if (!map.getMap().containsKey(cell)) {
                    listNearEmptyCell.add(cell);
                }
            }
        }
        //return arrayList;
    }

    public ArrayList<Cell> getListNearEmptyCell() {
        return listNearEmptyCell;
    }

    public void takeDamage(int damage) {
        this.HP -= damage;
        if (this.HP < 0) {
            this.HP = 0;
        }
    }

    public static int correctIntSteppingOutside(int entityRowOrColumn, int outsideMap) {
        int correctInt = 0;
        if (entityRowOrColumn < 1) {
            correctInt += outsideMap;
        } else if (entityRowOrColumn > outsideMap) {
            correctInt -= outsideMap;
        }
        return correctInt;
    }


    public void heal(int amount) {
        this.HP += amount;
    }


}
