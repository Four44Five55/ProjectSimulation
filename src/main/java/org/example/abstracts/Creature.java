package org.example.abstracts;

import org.example.interfaces.EnumEntity;
import org.example.model.Cell;
import org.example.model.SimulationMap;

import java.util.*;

abstract public class Creature extends Entity {
    private final int speed;
    private int HP;
    private int rangeOfVision;
    private String targetEntity;
    private int rangeOfAttack=1;

    public Creature(String name, int speed, int hp, int rangeOfVision, String targetEntity) {
        super(name);
        this.speed = speed;
        this.HP = hp;
        this.rangeOfVision = rangeOfVision;
        this.targetEntity = targetEntity;

    }
    //TODO: реализовать методы атаки и уменьшения ХП
    public void makeMove(SimulationMap simulationMap) {
        ArrayList<Cell> listNearEmptyCell = new ArrayList<>();
        ArrayList<Cell> listTargetCell = new ArrayList<>();

        //создание списков пустых ячеек и целей в области видимости
        for (int row = -rangeOfVision; row <= rangeOfVision; row++) {
            for (int column = -rangeOfVision; column <= rangeOfVision; column++) {
                int checkedRow = this.cell.getRow() + row;
                int checkedColumn = this.cell.getColumn() + column;
                Cell cell = new Cell(checkedRow + correctIntSteppingOutside(checkedRow, simulationMap.getTotalRows()),
                        checkedColumn + correctIntSteppingOutside(checkedColumn, simulationMap.getTotalColumns()));
                if (!simulationMap.getMap().containsKey(cell)) {
                    listNearEmptyCell.add(cell);
                } else if (simulationMap.getMap().get(cell).getName().equals(targetEntity)) {
                    listTargetCell.add(cell);
                }
            }
        }

        if (!listTargetCell.isEmpty()) {
            for (Cell cellTarget: listTargetCell){
                System.out.println("Хищник в ячейке " + this.cell.toString());
                System.out.println("Цель в ячейке " + cellTarget.toString());
                if (isTargetNearForAttack(cellTarget)) {
                    System.out.println(this.name + " " + this.cell.toString() + " Attacked " + simulationMap.getMap().get(cellTarget).getName() + " " + cellTarget);
                    Creature creature=(Creature) simulationMap.getMap().get(cellTarget);
                    creature.takeDamage(1);
                }
            }

        } else {
            Cell newCell = getRandomCellFromList(listNearEmptyCell);
            Cell oldCell = this.cell;
            if (newCell != null) {
                simulationMap.getMap().put(newCell, simulationMap.getMap().get(this.cell)); // Добавляем на новую клетку
                simulationMap.getMap().remove(oldCell);// Удаляем со старой клетки
            }
        }
    }

    private boolean isTargetNearForAttack(Cell cell) {
        if (Math.abs(this.cell.getRow() - cell.getRow()) <= rangeOfAttack && Math.abs(this.cell.getColumn() - cell.getColumn()) <= rangeOfAttack) {
            return true;
        } else {
            return false;
        }
    }

    private Cell getRandomCellFromList(ArrayList<Cell> cellArrayList) {
        Random randomizer = new Random();
        return cellArrayList.get(randomizer.nextInt(cellArrayList.size()));
    }
    public void toAttack(Cell cell){


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
