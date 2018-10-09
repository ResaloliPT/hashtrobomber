package org.academiadecodigo.bootcamp.Objects.Bomb;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Objects.Destroyable;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Position.Position;

public class PowerUp extends GameObject implements Destroyable {
    private PowerUpTypes type;

    public PowerUp(int x, int y, Field field){
        position = new Position(x, y, field);
        type = PowerUpTypes.values()[(int)Math.random() * PowerUpTypes.values().length];
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
