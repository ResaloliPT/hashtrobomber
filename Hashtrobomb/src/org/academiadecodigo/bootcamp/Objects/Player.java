package org.academiadecodigo.bootcamp.Objects;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Objects.Bomb.Bomb;
import org.academiadecodigo.bootcamp.Objects.Bomb.PowerUp;
import org.academiadecodigo.bootcamp.Objects.walls.Block;
import org.academiadecodigo.bootcamp.Objects.walls.Wall;
import org.academiadecodigo.bootcamp.Position.Directions;
import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player extends GameObject implements Destroyable {

    private String[] resource = {"resources/player1_down.png", "resources/player2_down.png"};
    private int maxBombs = 2;
    private int bombPower = 3;
    private int activeBombs = 0;
    private Picture character;
    private String name;


    public Player(String name, int col, int row, Field field, int type) {

        super(col, row, field);
        this.name = name;
        character = new Picture(position.getX(), position.getY(), resource[type]);
        character.draw();
        character.grow(2,2);

    }

    public void decreaseActiveBombs() {
        this.activeBombs--;
    }

    public void move(Directions direction) {

        switch (direction) {
            case UP:
                if (position.getRow() != position.getField().getMinRow()) {
                    character.delete();
                    position.setRow(position.getRow() - 1);
                    character.translate(0, -position.getField().getCellSize());
                    character.draw();
                }
                break;
            case DOWN:
                if (position.getRow() != position.getField().getMaxRow()) {
                    character.delete();
                    position.setRow(position.getRow() + 1);
                    character.translate(0, position.getField().getCellSize());
                    character.draw();
                }
                break;
            case LEFT:
                if (position.getCol() != position.getField().getMinCol()) {
                    character.delete();
                    position.setCol(position.getCol() - 1);
                    character.translate(-position.getField().getCellSize(), 0);
                    character.draw();
                }
                break;
            case RIGHT:
                if (position.getCol() != position.getField().getMaxCol()) {
                    character.delete();
                    position.setCol(position.getCol() + 1);
                    character.translate(position.getField().getCellSize(), 0);
                    character.draw();
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
                break;
            }
        }
        if (obj == null) {
            return true;
        }

        if(obj instanceof PowerUp){
            switch (((PowerUp) obj).getType()){
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


    public void setCharacter(String source){
        character.load(source);
    }

    public int getBombPower(){
        return bombPower;
    }

    public int getMaxBombs() {
        return maxBombs;
    }

    public String getName() {
        return name;
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
