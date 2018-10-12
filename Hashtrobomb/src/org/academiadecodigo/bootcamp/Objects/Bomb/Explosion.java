package org.academiadecodigo.bootcamp.Objects.Bomb;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Menu.BombMusic;
import org.academiadecodigo.bootcamp.Objects.Destroyable;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Explosion extends GameObject implements Destroyable {

    private Picture picture;

    public Explosion(int col, int row, Field field, String sprite) {
        super(col, row, field);

        picture = new Picture(position.getX(), position.getY(), sprite);
        picture.draw();
        picture.grow(2,2);

        Game.gameObjects.add(this);
    }

    @Override
    public void destroy() {
        this.destroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    public void erase() {
        picture.delete();
        Game.gameObjects.remove(this);
    }

}



