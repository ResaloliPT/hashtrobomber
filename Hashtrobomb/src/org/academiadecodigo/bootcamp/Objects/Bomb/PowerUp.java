package org.academiadecodigo.bootcamp.Objects.Bomb;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Objects.Destroyable;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PowerUp extends GameObject implements Destroyable {
    private PowerUpTypes type;
    private Picture powerUp;
    private String[] resource = {"resources/fireball.png", "resources/fireball.png"};


    public PowerUp(int col, int row, Field field){
        position = new Position(col, row, field);
        type = PowerUpTypes.values()[(int)(Math.random() * PowerUpTypes.values().length)];
        if(type == PowerUpTypes.BOMB){
            powerUp = new Picture(col,row,resource[1]);

        } else {
            powerUp = new Picture(col, row, resource[0]);

        }
        powerUp.draw();
    }

    public void initPowerUp(){

        if(type == PowerUpTypes.BOMB){

        }
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
