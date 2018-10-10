package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {
    private static final int PADDING = 50;
    private static final int MIN_COL = 0;
    private static final int MIN_ROW = 0;
    private static final int MAX_COL = 14;
    private static final int MAX_ROW = 14;
    private final int width = 600;
    private final int height = 600;
    private final int cellSize = 40;
    private final Rectangle field;

    public Field(){
        field = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
        field.setColor(Color.BLACK);
        field.draw();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getPadding(){
        return PADDING;
    }

    public static int getMinCol() {
        return MIN_COL;
    }

    public static int getMinRow() {
        return MIN_ROW;
    }

    public static int getMaxCol() {
        return MAX_COL;
    }

    public static int getMaxRow() {
        return MAX_ROW;
    }
}
