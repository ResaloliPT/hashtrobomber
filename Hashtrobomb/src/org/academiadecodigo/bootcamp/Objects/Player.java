package org.academiadecodigo.bootcamp.Objects;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Objects.Bomb.Bomb;
import org.academiadecodigo.bootcamp.Objects.walls.Block;
import org.academiadecodigo.bootcamp.Objects.walls.Wall;
import org.academiadecodigo.bootcamp.Position.Directions;
import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player extends GameObject implements Destroyable {

    private String[] resource = {"resources/Player1.png", "resources/player2.png"};
    private int maxBombs = 2;
    private int bombPower = 1;
    private int activeBombs = 0;
    private Picture character;


    public Player(String name, int col, int row, Field field, int type) {

        super(col, row, field);
        character = new Picture(position.getX(), position.getY(), resource[type]);
        character.draw();

    }

    public void decreaseActiveBombs() {
        this.activeBombs--;
    }

    public void move(Directions direction) {

        switch (direction) {
            case UP:
                if (position.getRow() != 0) {
                    character.translate(0, -position.getField().getCellSize());
                    position.setRow(position.getRow() - 1);
                }
                break;
            case DOWN:
                if (position.getRow() != 14) {
                    character.translate(0, position.getField().getCellSize());
                    position.setRow(position.getRow() + 1);
                }
                break;
            case LEFT:
                if (position.getCol() != 0) {
                    character.translate(-position.getField().getCellSize(), 0);
                    position.setCol(position.getCol() - 1);
                }
                break;
            case RIGHT:
                if (position.getCol() != 14) {
                    character.translate(position.getField().getCellSize(), 0);
                    position.setCol(position.getCol() + 1);
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

    public void increaseBombs(){
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
            }
        }
        if (obj == null) {
            return true;
        }

        return !(obj instanceof Block ||
                obj instanceof Wall ||
                obj instanceof Bomb);

    }


    public int getBombPower(){
        return bombPower;
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
