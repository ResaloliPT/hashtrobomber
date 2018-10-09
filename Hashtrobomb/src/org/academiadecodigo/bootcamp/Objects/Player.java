package org.academiadecodigo.bootcamp.Objects;

import org.academiadecodigo.bootcamp.Position.Directions;
import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends GameObject implements Destroyable {

            // Resource is for selecting images for different players!
    private String[] resource = {"resources/Player1.png", "resources/player2.png"};
    private String name;
    private int maxBombs = 10;
    private int bombPower = 1;
    private int activeBombs = 0;
    private Picture character;


    public Player(String name, int col, int row, Field field, int type){
        name = name;
        position = new Position(col,row, field);

        character = new Picture(position.getX(),position.getY(), resource[type]);
        character.draw();

    }

    public void move(Directions direction){

        switch (direction){
            case UP:
                if(position.getRow() != 0) {
                    character.translate(0, -position.getField().getCellSize());
                    position.setRow(position.getRow() - 1);
                }
                break;
            case DOWN:
                if(position.getRow() != 14) {
                    character.translate(0, position.getField().getCellSize());
                    position.setRow(position.getRow() + 1);
                }
                break;
            case LEFT:
                if(position.getCol() != 0) {
                    character.translate(-position.getField().getCellSize(), 0);
                    position.setCol(position.getCol() - 1);
                }
                break;
            case RIGHT:
                if(position.getCol() != 14) {
                    character.translate(position.getField().getCellSize(), 0);
                    position.setCol(position.getCol() + 1);
                }
                break;
        }
    }

    public void dropBomb(){
        if(activeBombs < maxBombs) {
            ObjectFactory.createBomb(position.getCol(), position.getRow(), this, bombPower, position.getField());
            activeBombs++;
        }
    }

    public void returningBomb() {
        if(activeBombs > 0){
            activeBombs--;
        }
    }

    public void increaseBombs(){
        maxBombs++;
    }

    public void increasePower(){
        bombPower++;
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
