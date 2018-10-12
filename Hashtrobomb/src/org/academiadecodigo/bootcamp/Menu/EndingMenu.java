package org.academiadecodigo.bootcamp.Menu;

import org.academiadecodigo.bootcamp.Objects.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class EndingMenu {

    private String[] resource = {"resources/gameOver.jpg"};
    private static final int PADDING = 10;
    private Picture end;


    public EndingMenu() {
        end = new Picture(PADDING, PADDING, resource[0]);
        end.draw();

    }

}