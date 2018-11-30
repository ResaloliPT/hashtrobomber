package org.academiadecodigo.bootcamp.Objects.walls;

import org.academiadecodigo.bootcamp.Objects.DestoyableAbstract;
import org.academiadecodigo.bootcamp.Objects.ObjectFactory;
import org.academiadecodigo.bootcamp.configs.RenderConfigs;

public class Block extends DestoyableAbstract {

    private boolean powerUp;

    public Block(int col, int row, boolean powerUp){
        super(col, row, RenderConfigs.MAP_BLOCK);
        this.powerUp = powerUp;
    }

    @Override
    public void destroy(){
        if(powerUp){

            ObjectFactory.createPowerUp(getCol(), getRow());
        }

        super.destroy();
    }
}
