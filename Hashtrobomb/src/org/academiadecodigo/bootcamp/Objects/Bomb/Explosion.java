package org.academiadecodigo.bootcamp.Objects.Bomb;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Objects.Destroyable;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Explosion extends GameObject implements Destroyable {

    private Rectangle explosion;

    public Explosion(int col, int row, Field field) {
        position = new Position(col,row, field);
        explosion = new Rectangle(position.getX(), position.getY(), field.getCellSize(), field.getCellSize());
        explosion.setColor(Color.RED);
        init();

    }



    public void init() {
        explosion.fill();
    }

    public void erase() {
        explosion.delete();
        destroy();
    }


    @Override
    public void destroy() {
        this.destroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }
}