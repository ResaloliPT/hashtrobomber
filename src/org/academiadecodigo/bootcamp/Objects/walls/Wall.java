package org.academiadecodigo.bootcamp.Objects.walls;

import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.configs.RenderConfigs;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Wall extends GameObject {

    private Picture wallSprite;

    public Wall (int col, int row){
        super(col, row);
        wallSprite = new Picture(position.getX(), position.getY(), RenderConfigs.MAP_WALL);
        wallSprite.draw();
    }
}