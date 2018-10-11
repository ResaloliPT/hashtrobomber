package org.academiadecodigo.bootcamp.Objects.Bomb;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Explosion extends GameObject {

    private Picture picture;

    public Explosion(int col, int row, Field field) {
        super(col, row, field);
        picture = new Picture(position.getX(), position.getY(), "resources/explosion_center.png");
        picture.draw();
        Game.gameObjects.add(this);
    }


    public void erase() {
        picture.delete();
    }
}



