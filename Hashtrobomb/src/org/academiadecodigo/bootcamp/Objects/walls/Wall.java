package org.academiadecodigo.bootcamp.Objects.walls;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Wall extends GameObject {

    private Picture wallSprite;

    public Wall (int col, int row, Field field){

        super(col, row, field);
        wallSprite = new Picture(position.getX(), position.getY(), "resources/Preview_154.png");
        wallSprite.draw();
    }
}
