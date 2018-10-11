package org.academiadecodigo.bootcamp.Position;

import javafx.geometry.Pos;
import org.academiadecodigo.bootcamp.Field;

public class Position {
    private int col;
    private int row;
    private int x;
    private int y;
    private Field field;

    public Position(int col, int row,Field field) {
        this.col = col;
        this.row = row;
        this.x = (col * field.getCellSize()) + field.getPadding();
        this.y = (row * field.getCellSize()) + field.getPadding();
        this.field = field;
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
        return x;
    }

    public int getY() {
        return y;
    }

    public Field getField() {
        return field;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    @Override
    public boolean equals(Object pos) {
        if (pos instanceof Position) {
            return ((Position) pos).getCol() == col && ((Position)pos).getRow() == row;
        }
        return false;
    }
}
