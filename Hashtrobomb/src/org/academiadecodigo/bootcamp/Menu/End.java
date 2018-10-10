package org.academiadecodigo.bootcamp.Menu;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class End {

    private String[] resource = {"resources/end.png"};
    private static final int PADDING = 10;
    private Picture end;


    public End() {
        end = new Picture(PADDING, PADDING, resource[0]);
        end.draw();

    }


    public void end() {
        end.draw();
    }

}