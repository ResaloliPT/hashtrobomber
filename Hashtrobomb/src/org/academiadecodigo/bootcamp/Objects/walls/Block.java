package org.academiadecodigo.bootcamp.Objects.walls;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Objects.Destroyable;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Objects.ObjectFactory;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.swing.*;

public class Block extends GameObject implements Destroyable {
    private boolean powerUp;
    private Picture block;

    public Block(int col, int row, Field field, boolean powerUp){
        super(col, row, field);
        this.powerUp = powerUp;

        block = new Picture(position.getX(), position.getY(), "resources/RTS_Crate_0.png");
        block.draw();
        //block.setColor(Color.ORANGE);
        //block.fill();
    }

    @Override
    public void destroy(){
        if(powerUp){
            ObjectFactory.createPowerUp(position.getX(), position.getY(), position.getField());
        }
        destroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }
}
