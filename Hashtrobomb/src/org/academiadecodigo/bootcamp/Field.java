package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {
    private static final int PADDING = 50;
    private int width = 600;
    private int height = 600;
    private int cellSize = 40;
    private Rectangle field;


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
}
