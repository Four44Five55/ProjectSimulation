package org.example.model;

import org.example.interfaces.CellInterface;

import java.util.Objects;

public class Cell implements CellInterface {
    private int row;
    private int column;

    public Cell() {
    }

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }


    public void setRow(int row) {
        this.row = row;
    }


    @Override
    public CellInterface getCell() {
        return Cell.this;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return row == cell.row && column == cell.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return
                "row=" + row +
                        ", column=" + column
                ;
    }
}
