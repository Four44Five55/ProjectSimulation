package org.example.abstracts;

import org.example.actions.MapConsoleRenderer;
import org.example.interfaces.EnumEntitySpecies;
import org.example.model.Cell;
import org.example.model.Grass;
import org.example.model.Herbivore;
import org.example.model.SimulationMap;

import java.util.*;

import static org.example.actions.SearchAlgorithm.breadthFirstSearch;

abstract public class Creature extends Entity {
    private final int speed;
    private int HP;
    private final int rangeOfVision;
    private final String targetEntity;
    private final int rangeOfAttack = 1;
    private final int powerAttack;

    public Creature(String name, EnumEntitySpecies enumEntitySpecies, int speed, int hp, int rangeOfVision, String targetEntity, int powerAttack) {
        super(name, enumEntitySpecies);
        this.speed = speed;
        this.HP = hp;
        this.rangeOfVision = rangeOfVision;
        this.targetEntity = targetEntity;
        this.powerAttack = powerAttack;
    }

    //TODO: реализовать методы атаки и уменьшения ХП
    public void makeMove(SimulationMap simulationMap) throws InterruptedException {
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
                    if (Math.abs(cell.getRow() - this.cell.getRow()) <= speed && Math.abs(cell.getColumn() - this.cell.getColumn()) <= speed) {
                        listNearEmptyCell.add(cell);
                    }

                } else if (simulationMap.getMap().get(cell).getName().equals(targetEntity)) {
                    listTargetCell.add(cell);
                }
            }
        }

        if (!listTargetCell.isEmpty()) {
            for (Cell cellTarget : listTargetCell) {
                if (isTargetNearForAttack(cellTarget)) {
                    switch (simulationMap.getMap().get(cellTarget).getEnumEntitySpecies()) {
                        case HERBIVORE -> {
                            Herbivore herbivore = (Herbivore) simulationMap.getMap().get(cellTarget);
                            herbivore.takeDamage(this.powerAttack);
                            System.out.printf("%s(%s) атаковал %s(%s)", simulationMap.getMap().get(this.cell), this.cell, simulationMap.getMap().get(cellTarget), cellTarget);
                            System.out.println();
                            if (herbivore.isDead()) {
                                System.out.println(simulationMap.getMap().get(cellTarget).getName() + " " + cellTarget + " съеден");
                                simulationMap.removeEntity(cellTarget);
                            }
                        }
                        case GRASS -> {
                            Grass grass = (Grass) simulationMap.getMap().get(cellTarget);
                            grass.takeDamage(this.powerAttack);
                            System.out.printf("%s(%s) атаковал %s(%s)", simulationMap.getMap().get(this.cell), this.cell, simulationMap.getMap().get(cellTarget), cellTarget);
                            System.out.println();
                            if (grass.isDead()) {
                                System.out.println(simulationMap.getMap().get(cellTarget).getName() + " " + cellTarget + " съеден");
                                simulationMap.removeEntity(cellTarget);
                            }
                        }
                    }
                    break;
                } else {
                    toMoveToTarget(this.cell, cellTarget, simulationMap);
                    break;
                }
            }
        } else {
            toRandomMove(simulationMap, listNearEmptyCell);
        }
        MapConsoleRenderer.render(simulationMap);
    }


    public Cell getCellToMoveToTarget(Cell start, Cell target, SimulationMap simulationMap) {
        ArrayList<Cell> arrayList = new ArrayList<>();
        Map<Cell, Cell> visitedCells = breadthFirstSearch(start, target, simulationMap);
        Cell nearCell = visitedCells.get(target);

        arrayList.add(visitedCells.get(target));
        while (!start.equals(nearCell)) {
            arrayList.add(visitedCells.get(nearCell));
            nearCell = visitedCells.get(nearCell);
        }
        //обход OutOfBoundException с учетом дальности движения существа
        if (arrayList.size() > 2) {
            return arrayList.get(arrayList.size() - 1 - speed);
        } else {
            return arrayList.get(0);
        }
    }

    private void toMoveToTarget(Cell start, Cell target, SimulationMap simulationMap) {
        Cell newCell = getCellToMoveToTarget(start, target, simulationMap);
        Cell oldCell = this.cell;

        if (newCell != null && !newCell.equals(oldCell)) {
            simulationMap.setEntity(newCell, simulationMap.getMap().get(this.cell));
            System.out.printf("%s(%s) перешел на (%s), в направлении %s(%s)", simulationMap.getMap().get(newCell), oldCell, newCell, simulationMap.getMap().get(target), target);
            System.out.println();
            simulationMap.removeEntity(oldCell);
        }
    }

    private void toRandomMove(SimulationMap simulationMap, ArrayList<Cell> arrayList) {
        Cell newCell = getRandomCellFromList(arrayList);
        Cell oldCell = this.cell;

        if (newCell != null && !newCell.equals(oldCell)) {
            simulationMap.setEntity(newCell, simulationMap.getMap().get(this.cell));
            System.out.printf("%s(%s) в поиске цели перешел на %s", simulationMap.getMap().get(newCell), oldCell, newCell);
            System.out.println();
            simulationMap.removeEntity(oldCell);
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
