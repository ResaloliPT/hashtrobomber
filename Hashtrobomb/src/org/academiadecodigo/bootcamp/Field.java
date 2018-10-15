package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {
    public static final int PADDING = 60;
    public static final int MIN_COL = 0;
    public static final int MIN_ROW = 0;
    public static final int MAX_COL = 14;
    public static final int MAX_ROW = 14;
    public static final int CELL_SIZE = 40;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    private final Rectangle field;


    public Field(){
        field = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        field.setColor(Color.BLACK);
        field.draw();
    }
}
