package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Objects.ObjectFactory;
import org.academiadecodigo.bootcamp.configs.RenderConfigs;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;

public class Level {

    private Field field;
    private List<GameObject> elements = new LinkedList<>();
    private Picture background;

    public Level(Field field) {
        this.field = field;
        background = new Picture(10, 10, RenderConfigs.MAP_BG);
        background.draw();
    }

    public List<GameObject> level1() {
        addWall(1, 1);
        addWall(3, 1);
        addWall(5, 1);
        addWall(7, 1);
        addWall(9, 1);
        addWall(11, 1);
        addWall(13, 1);
        addWall(1, 3);
        addWall(3, 3);
        addWall(5, 3);
        addWall(7, 3);
        addWall(9, 3);
        addWall(11, 3);
        addWall(13, 3);
        addWall(1, 5);
        addWall(3, 5);
        addWall(5, 5);
        addWall(7, 5);
        addWall(9, 5);
        addWall(11, 5);
        addWall(13, 5);
        addWall(1, 7);
        addWall(3, 7);
        addWall(5, 7);
        addWall(7, 7);
        addWall(9, 7);
        addWall(11, 7);
        addWall(13, 7);
        addWall(1, 9);
        addWall(3, 9);
        addWall(5, 9);
        addWall(7, 9);
        addWall(9, 9);
        addWall(11, 9);
        addWall(13, 9);
        addWall(1, 11);
        addWall(3, 11);
        addWall(5, 11);
        addWall(7, 11);
        addWall(9, 11);
        addWall(11, 11);
        addWall(13, 11);
        addWall(1, 13);
        addWall(3, 13);
        addWall(5, 13);
        addWall(7, 13);
        addWall(9, 13);
        addWall(11, 13);
        addWall(13, 13);
        generateBlocks();
        return elements;
    }

    public List<GameObject> level2() {
        addWall(7, 0);
        addWall(1, 1);
        addWall(3, 1);
        addWall(5, 1);
        addWall(7, 1);
        addWall(9, 1);
        addWall(11, 1);
        addWall(13, 1);
        addWall(1, 3);
        addWall(2, 3);
        addWall(4, 3);
        addWall(6, 3);
        addWall(8, 3);
        addWall(10, 3);
        addWall(12, 3);
        addWall(13, 3);
        addWall(4, 4);
        addWall(10, 4);
        addWall(0, 5);
        addWall(2, 5);
        addWall(7, 5);
        addWall(12, 5);
        addWall(14, 5);
        addWall(2, 6);
        addWall(4, 6);
        addWall(5, 6);
        addWall(7, 6);
        addWall(9, 6);
        addWall(10, 6);
        addWall(12, 6);
        addWall(2, 8);
        addWall(4, 8);
        addWall(5, 8);
        addWall(7, 8);
        addWall(9, 8);
        addWall(10, 8);
        addWall(12, 8);
        addWall(0, 9);
        addWall(2, 9);
        addWall(7, 9);
        addWall(12, 9);
        addWall(14, 9);
        addWall(4, 10);
        addWall(10, 10);
        addWall(1, 11);
        addWall(2, 11);
        addWall(4, 11);
        addWall(6, 11);
        addWall(8, 11);
        addWall(10, 11);
        addWall(12, 11);
        addWall(13, 11);
        addWall(1, 13);
        addWall(3, 13);
        addWall(5, 13);
        addWall(7, 13);
        addWall(9, 13);
        addWall(11, 13);
        addWall(13, 13);
        addWall(7, 14);
        generateBlocks();
        return elements;
    }

    public void generateBlocks() {
        for (int col = Field.MIN_COL; col <= Field.MAX_COL; col++) {
            for (int row = Field.MIN_ROW; row <= Field.MAX_ROW; row++) {
                if (!((col == Field.MIN_COL && row == Field.MIN_ROW) ||
                        (col == Field.MIN_COL && row == Field.MIN_ROW + 1) ||
                        (col == Field.MIN_COL + 1 && row == Field.MIN_ROW) ||
                        (col == Field.MAX_COL && row == Field.MAX_ROW) ||
                        (col == Field.MAX_COL && row == Field.MAX_ROW - 1) ||
                        (col == Field.MAX_COL - 1 && row == Field.MAX_ROW))) {

                    int blockProbability = (int) (Math.random() * 100);

                    if (blockProbability < 85) {
                        addBlock(col, row);
                    }
                }
            }
        }
    }

    public void addWall(int col, int row) {
        elements.add(ObjectFactory.createWall(col, row));
    }

    public void addBlock(int col, int row) {
        for (GameObject o : elements){
            if (o.getPosition().getCol() == col && o.getPosition().getRow() == row){
                return;
            }
        }
        elements.add(ObjectFactory.createBlock(col, row));
    }
}
