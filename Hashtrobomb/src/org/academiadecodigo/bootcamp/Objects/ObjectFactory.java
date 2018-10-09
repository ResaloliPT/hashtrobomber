package org.academiadecodigo.bootcamp.Objects;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Objects.Bomb.Bomb;
import org.academiadecodigo.bootcamp.Objects.Bomb.PowerUp;
import org.academiadecodigo.bootcamp.Objects.walls.Block;
import org.academiadecodigo.bootcamp.Objects.walls.Wall;

public class ObjectFactory {

    public static Player createPlayer(String name, int col, int row, Field field, int type){
        return new Player(name, col, row, field, type);
    }

    public static Wall createWall(int col, int row, Field field){
        return new Wall(col, row, field);
    }

    public static Block createBlock(int col, int row, Field field){
        int powerUpProbability = (int)Math.random()*100;
        boolean powerUp = (powerUpProbability <= 15) ? true : false;

        return new Block(col, row, field, powerUp);
    }

    public static PowerUp createPowerUp(int col, int row, Field field){
        return new PowerUp(col, row, field);
    }

    public static Bomb createBomb(int col, int row, Player player, int power, Field field){
        return new Bomb(col, row, player, power, field);
    }
}
