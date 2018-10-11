package org.academiadecodigo.bootcamp.Objects.walls;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Wall extends GameObject {

    private Picture wall;

    public Wall (int x, int y, Field field){
        position = new Position(x, y, field);

        wall = new Picture(position.getX(), position.getY(), "resources/wall.png");
        wall.draw();
    }
}
