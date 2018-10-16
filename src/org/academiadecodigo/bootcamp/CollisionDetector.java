package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Position.Position;

public class CollisionDetector {

    public static boolean checkCollision(int col, int row){

        Position position = new Position(col, row);

        for(GameObject gameObject : Game.gameObjects){
            if(position.equals(gameObject.getPosition())){
                return true;
            }
        }
        return false;
    }

    /**Overload*/
    public static boolean checkCollision(Position position){

        for (GameObject gameObject : Game.gameObjects){
            if (position.equals((gameObject.getPosition()))){
                return true;
            }
        }
        return false;
    }

    /**Overload*/
    public static GameObject checkCollision(GameObject objectArg){

        for (GameObject gameObject : Game.gameObjects){
            if(objectArg.getPosition().equals(gameObject.getPosition())){
                return gameObject;
            }
        }
        return null;
    }

}
