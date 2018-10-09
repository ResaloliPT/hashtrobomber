package org.academiadecodigo.bootcamp.Objects.walls;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Wall extends GameObject {

    private Rectangle wall;

    public Wall (int x, int y, Field field){
        position = new Position(x, y, field);

        wall = new Rectangle(position.getX(), position.getY(), field.getCellSize(), field.getCellSize());
        wall.setColor(Color.GRAY);
        wall.fill();
    }
}
