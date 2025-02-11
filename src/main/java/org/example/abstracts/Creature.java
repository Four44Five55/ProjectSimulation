package org.example.abstracts;

import org.example.model.Cell;
import org.example.model.Grass;
import org.example.model.Herbivore;
import org.example.model.SimulationMap;

import java.util.*;

abstract public class Creature extends Entity {
    private final int speed;
    private int HP;
    private final int rangeOfVision;
    private final String targetEntity;
    private final int rangeOfAttack = 1;
    private final int powerAttack;

    public Creature(String name, int speed, int hp, int rangeOfVision, String targetEntity, int powerAttack) {
        super(name);
        this.speed = speed;
        this.HP = hp;
        this.rangeOfVision = rangeOfVision;
        this.targetEntity = targetEntity;
        this.powerAttack = powerAttack;
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
            for (Cell cellTarget : listTargetCell) {

                if (isTargetNearForAttack(cellTarget)) {

                    if (simulationMap.getMap().get(cellTarget) instanceof Herbivore herbivore) {
                        herbivore.takeDamage(this.powerAttack);
                        if (herbivore.isDead()) {
                            System.out.println(simulationMap.getMap().get(cellTarget).getName() + " " + cellTarget + " съеден");
                            simulationMap.removeEntity(cellTarget);
                        }
                    } else if (simulationMap.getMap().get(cellTarget) instanceof Grass grass) {
                        grass.takeDamage(this.powerAttack);
                        if (grass.isDead()) {
                            System.out.println(simulationMap.getMap().get(cellTarget).getName() + " " + cellTarget + " съеден");
                            simulationMap.removeEntity(cellTarget);
                        }
                    }
                }
            }

        } else {
            Cell newCell = getRandomCellFromList(listNearEmptyCell);
            Cell oldCell = this.cell;

            if (newCell != null && !newCell.equals(oldCell)) {
                simulationMap.setEntity(newCell, simulationMap.getMap().get(this.cell));
                simulationMap.removeEntity(oldCell);

               /* simulationMap.getMap().put(newCell, simulationMap.getMap().get(this.cell)); // Добавляем на новую клетку
                simulationMap.getMap().remove(oldCell); // Удаляем со старой клетки
                this.cell = newCell; // Обновляем внутреннее состояние*/
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

    protected boolean isDead() {
        return this.HP <= 0;
    }

    private Cell getRandomCellFromList(ArrayList<Cell> cellArrayList) {
        Random randomizer = new Random();
        return cellArrayList.get(randomizer.nextInt(cellArrayList.size()));
    }

    public int getPowerAttack() {
        return powerAttack;
    }

    public void toAttack(Creature creature) {
        creature.takeDamage(this.powerAttack);
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
