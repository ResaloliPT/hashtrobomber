package org.academiadecodigo.bootcamp.Objects;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Objects.Bomb.Bomb;
import org.academiadecodigo.bootcamp.Objects.Bomb.PowerUp;
import org.academiadecodigo.bootcamp.Objects.walls.Block;
import org.academiadecodigo.bootcamp.Objects.walls.Wall;
import org.academiadecodigo.bootcamp.Position.Directions;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player extends DestoyableAbstract {

    private int maxBombs = 1;
    private int bombPower = 1;
    private int activeBombs = 0;
    private String name;


    public Player(String name, int col, int row, String startIMG) {
        super(col, row, startIMG);
        this.name = name;
        growImg(2, 2);
    }

    public void decreaseActiveBombs() {
        this.activeBombs--;
    }

    public void move(Directions direction) {

        switch (direction) {
            case UP:
                if (getRow() != Field.MIN_ROW) {
                    setRow(getRow() - 1);
                    tanslateImg(0, -Field.CELL_SIZE);
                }
                break;
            case DOWN:
                if (getRow() != Field.MAX_ROW) {
                    setRow(getRow() + 1);
                    tanslateImg(0, Field.CELL_SIZE);
                }
                break;
            case LEFT:
                if (getCol() != Field.MIN_COL) {
                    setCol(getCol() - 1);
                    tanslateImg(-Field.CELL_SIZE, 0);
                }
                break;
            case RIGHT:
                if (getCol() != Field.MAX_COL) {
                    setCol(getCol() + 1);
                    tanslateImg(Field.CELL_SIZE, 0);
                }
                break;
        }
    }

    public boolean dropBomb() {
        if (activeBombs < maxBombs) {
            activeBombs++;
            return true;
        }
        return false;
    }

    public void increaseBombs() {
        maxBombs++;
    }

    public void increasePower() {
        bombPower++;
    }

    public boolean isMovementAvailable(Position targetPosition) {

        GameObject obj = null;

        for (GameObject gameObject : Game.gameObjects) {
            if (gameObject.getCol() == targetPosition.getCol() && gameObject.getRow() == targetPosition.getRow()) {
                obj = gameObject;
                break;
            }
        }

        if (obj == null) {
            return true;
        }

        if (obj instanceof PowerUp) {
            switch (((PowerUp) obj).getType()) {
                case POWER:
                    this.increasePower();
                    ((PowerUp) obj).destroy();
                    break;
                case BOMB:
                    this.increaseBombs();
                    ((PowerUp) obj).destroy();
                    break;
            }
        }

        return !(obj instanceof Block ||
                obj instanceof Wall ||
                obj instanceof Bomb);
    }


    public void setCharacter(String source) {
        changeImage(source);
    }

    public int getBombPower() {
        return bombPower;
    }

    public String getName() {
        return name;
    }

    public int getActiveBombs() {
        return activeBombs;
    }

    public int getMaxBombs() {
        return maxBombs;
    }
}
