package org.academiadecodigo.bootcamp.Objects.walls;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Objects.Destroyable;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Objects.ObjectFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Block extends GameObject implements Destroyable {
    private boolean powerUp;
    private Picture block;
    private Picture powerUpObj;

    public Block(int col, int row, Field field, boolean powerUp){
        super(col, row, field);
        this.powerUp = powerUp;

        block = new Picture(position.getX(), position.getY(), "resources/RTS_Crate_0.png");
        block.draw();
        powerUpObj = new Picture(position.getX(),position.getY(),"resources/fireball.png");

    }

    @Override
    public void destroy(){
        if(powerUp){
            ObjectFactory.createPowerUp(position.getCol(), position.getRow(), position.getField());
        }
        block.delete();
        destroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }
}
