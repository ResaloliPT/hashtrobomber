package org.academiadecodigo.bootcamp.Objects.Bomb;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Objects.Destroyable;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PowerUp extends GameObject implements Destroyable {
    private PowerUpTypes type;
    private Rectangle powerup;
    private String[] resource = {"resources/fireball.png"};

    public PowerUp(int col, int row, Field field){
        position = new Position(col, row, field);

        powerup = new Rectangle(position.getX(), position.getY(), field.getCellSize(), field.getCellSize());
        powerup.setColor(Color.BLUE);
        powerup.fill();
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
