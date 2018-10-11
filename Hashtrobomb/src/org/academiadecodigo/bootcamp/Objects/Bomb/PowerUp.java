package org.academiadecodigo.bootcamp.Objects.Bomb;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Objects.Destroyable;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PowerUp extends GameObject implements Destroyable {
    private PowerUpTypes type;
<<<<<<< HEAD
    private Rectangle powerup;
    private String[] resource = {"resources/fireball.png"};

    public PowerUp(int col, int row, Field field){
        position = new Position(col, row, field);

        powerup = new Rectangle(position.getX(), position.getY(), field.getCellSize(), field.getCellSize());
        powerup.setColor(Color.BLUE);
        powerup.fill();
=======
    private Picture powerUp;
    private String[] resource = {"resources/fireball.png", "resources/fireball.png"};

    public PowerUp(int col, int row, Field field){
        position = new Position(col, row, field);
>>>>>>> 1f08e6124e7331e03042650bee00825478041060
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
