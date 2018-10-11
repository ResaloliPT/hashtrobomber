package org.academiadecodigo.bootcamp.Objects.walls;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Objects.GameObject;
<<<<<<< HEAD
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
=======
import org.academiadecodigo.bootcamp.Position.Position;
>>>>>>> develop
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Wall extends GameObject {

<<<<<<< HEAD
    private Picture wallSprite;
=======
    private Picture wall;
>>>>>>> develop

    public Wall (int col, int row, Field field){

<<<<<<< HEAD
        super(col, row, field);
        wallSprite = new Picture(position.getX(), position.getY(), "resources/Preview_154.png");
        wallSprite.draw();
=======
        wall = new Picture(position.getX(), position.getY(), "resources/wall.png");
        wall.draw();
>>>>>>> develop
    }
}
