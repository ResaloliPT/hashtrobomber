package org.academiadecodigo.bootcamp.Objects;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Objects.Bomb.Bomb;
import org.academiadecodigo.bootcamp.Objects.Bomb.Explosion;
import org.academiadecodigo.bootcamp.Objects.Bomb.PowerUp;
import org.academiadecodigo.bootcamp.Objects.walls.Block;
import org.academiadecodigo.bootcamp.Objects.walls.Wall;

public class ObjectFactory {

    public static Player createPlayer(String name, int col, int row, int type) {
        return new Player(name, col, row, type);
    }

    public static Wall createWall(int col, int row) {
        return new Wall(col, row);
    }

    public static Block createBlock(int col, int row) {
        int powerUpProbability = (int) (Math.random() * 100);
        boolean powerUp = (powerUpProbability <= 15) ? true : false;

        return new Block(col, row, powerUp);
    }

    public static PowerUp createPowerUp(int col, int row) {
        return new PowerUp(col, row);
    }

    public static Bomb createBomb(int col, int row, Player player, int power) {
        return new Bomb(col, row, player, power);
    }

    public static Explosion createExplosion(int col, int row, String sprite) {
        return new Explosion(col, row, sprite);
    }
}
