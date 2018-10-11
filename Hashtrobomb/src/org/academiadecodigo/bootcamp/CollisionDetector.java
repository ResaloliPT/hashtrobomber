package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Position.Position;

import java.util.List;

public class CollisionDetector {


    public static boolean checkCollision(Position position){

        for(GameObject gameObject : Game.gameObjects){

            if(position.equals(gameObject.getPosition())){
                return true;
            }
        }

        return false;
    }
}
