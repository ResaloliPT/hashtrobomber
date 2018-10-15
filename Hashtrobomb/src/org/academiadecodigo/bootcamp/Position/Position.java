package org.academiadecodigo.bootcamp.Position;

import org.academiadecodigo.bootcamp.Field;

public class Position {
    private int col;
    private int row;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getX() {
        return (col * Field.CELL_SIZE) + Field.PADDING;
    }

    public int getY() {
        return (row * Field.CELL_SIZE) + Field.PADDING;
    }

    @Override
    public boolean equals(Object pos) {
        if (pos instanceof Position) {
            return ((Position) pos).getCol() == col && ((Position)pos).getRow() == row;
        }
        return false;
    }
}
