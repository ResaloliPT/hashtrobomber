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
        addWall(2,1);
        addWall(2,0);
        return elements;
    }

    public void addWall(int x, int y){
        elements.add(ObjectFactory.createWall(x, y, field));
    }
}
