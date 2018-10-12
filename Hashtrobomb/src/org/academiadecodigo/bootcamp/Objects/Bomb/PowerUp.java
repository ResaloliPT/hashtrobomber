package org.academiadecodigo.bootcamp.Objects.Bomb;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Objects.Destroyable;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PowerUp extends GameObject implements Destroyable {

    private PowerUpTypes type;
    private Picture pwrUpSprite;
    private String[] resource = {"resources/powerup_power.png", "resources/powerup_bomb.png"};

    public PowerUp(int col, int row, Field field){
        super(col, row, field);
        type = PowerUpTypes.values()[(int)(Math.random() * PowerUpTypes.values().length)];
        initPowerUp(type);
        pwrUpSprite.draw();
        Game.gameObjects.add(this);
    }

    public void initPowerUp(PowerUpTypes type){

        if(type == PowerUpTypes.BOMB){
            pwrUpSprite = new Picture(position.getX(), position.getY(), resource[1]);
        } else {
            pwrUpSprite = new Picture(position.getX(), position.getY(), resource[0]);
        }
    }

    public PowerUpTypes getType() {
        return type;
    }

    @Override
    public void destroy() {
        destroyed = true;
        Game.gameObjects.remove(this);
        this.pwrUpSprite.delete();
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }
}
