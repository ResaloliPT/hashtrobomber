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


public class Player extends GameObject implements Destroyable {

    private String[] resource = {"resources/player1_down.png", "resources/player2_down.png"};
    private int maxBombs = 1;
    private int bombPower = 1;
    private int activeBombs = 0;
    private Picture character;
    private String name;


    public Player(String name, int col, int row, String startIMG) {
        super(col, row);
        this.name = name;
        character = new Picture(position.getX(), position.getY(), startIMG);
        character.draw();
        character.grow(2, 2);
    }

    public void decreaseActiveBombs() {
        this.activeBombs--;
    }

    public void move(Directions direction) {

        switch (direction) {
            case UP:
                if (position.getRow() != Field.MIN_ROW) {
                    position.setRow(position.getRow() - 1);
                    character.translate(0, -Field.CELL_SIZE);
                }
                break;
            case DOWN:
                if (position.getRow() != Field.MAX_ROW) {
                    position.setRow(position.getRow() + 1);
                    character.translate(0, Field.CELL_SIZE);
                }
                break;
            case LEFT:
                if (position.getCol() != Field.MIN_COL) {
                    position.setCol(position.getCol() - 1);
                    character.translate(-Field.CELL_SIZE, 0);
                }
                break;
            case RIGHT:
                if (position.getCol() != Field.MAX_COL) {
                    position.setCol(position.getCol() + 1);
                    character.translate(Field.CELL_SIZE, 0);
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
            if (targetPosition.equals(gameObject.getPosition())) {
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
        character.load(source);
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

    @Override
    public void destroy() {
        destroyed = true;
        this.character.delete();
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

}
