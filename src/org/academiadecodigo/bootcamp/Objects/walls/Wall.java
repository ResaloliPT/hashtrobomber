package org.academiadecodigo.bootcamp.Objects.walls;

import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.configs.RenderConfigs;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Wall extends GameObject {

    public Wall (int col, int row){
        super(col, row, RenderConfigs.MAP_WALL);
    }
}
