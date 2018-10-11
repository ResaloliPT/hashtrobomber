package org.academiadecodigo.bootcamp.Objects.Bomb;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Objects.Destroyable;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PowerUp extends GameObject implements Destroyable {
    private PowerUpTypes type;
    private Picture pwrUpSprite;
    private String[] resource = {"resources/fireball.png"};

    public PowerUp(int col, int row, Field field){
        super(col, row, field);
        type = PowerUpTypes.values()[(int)(Math.random() * PowerUpTypes.values().length)];
    }

    @Override
    public void destroy() {
        destroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }
}
