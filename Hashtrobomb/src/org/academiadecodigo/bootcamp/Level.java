package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Objects.ObjectFactory;

import java.util.LinkedList;
import java.util.List;

public class Level {

    private Field field;
    private List<GameObject> elements = new LinkedList<>();


    public Level(Field field){
        this.field = field;
    }

    public List<GameObject> level1() {
        addWall(1,1);
        addWall(3,1);
        addWall(5,1);
        addWall(7,1);
        addWall(9,1);
        addWall(11,1);
        addWall(13,1);

        addWall(1,3);
        addWall(3,3);
        addWall(5,3);
        addWall(7,3);
        addWall(9,3);
        addWall(11,3);
        addWall(13,3);

        addWall(1,5);
        addWall(3,5);
        addWall(5,5);
        addWall(7,5);
        addWall(9,5);
        addWall(11,5);
        addWall(13,5);

        addWall(1,7);
        addWall(3,7);
        addWall(5,7);
        addWall(7,7);
        addWall(9,7);
        addWall(11,7);
        addWall(13,7);

        addWall(1,9);
        addWall(3,9);
        addWall(5,9);
        addWall(7,9);
        addWall(9,9);
        addWall(11,9);
        addWall(13,9);

        addWall(1,11);
        addWall(3,11);
        addWall(5,11);
        addWall(7,11);
        addWall(9,11);
        addWall(11,11);
        addWall(13,11);

        addWall(1,13);
        addWall(3,13);
        addWall(5,13);
        addWall(7,13);
        addWall(9,13);
        addWall(11,13);
        addWall(13,13);

        return elements;
    }

    public void addWall(int x, int y){
        elements.add(ObjectFactory.createWall(x, y, field));
    }
}
