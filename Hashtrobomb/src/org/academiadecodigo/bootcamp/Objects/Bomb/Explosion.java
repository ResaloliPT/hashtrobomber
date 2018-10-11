package org.academiadecodigo.bootcamp.Objects.Bomb;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Explosion extends GameObject {

    private Picture picture;
    private int power;

    public Explosion(int col, int row, int power, Field field) {
       super(col, row, field);
       this.power = power;
    }

}
