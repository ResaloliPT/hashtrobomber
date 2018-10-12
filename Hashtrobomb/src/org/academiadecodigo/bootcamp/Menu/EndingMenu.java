package org.academiadecodigo.bootcamp.Menu;

import org.academiadecodigo.bootcamp.Objects.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class EndingMenu {

    private String[] resource = {"resources/player1wins.jpg", "resources/player2wins.jpg"};
    private static final int PADDING = 10;
    private Picture end;


    public EndingMenu(Player winner) {

        if (winner.getName().equals("player1")) {
            end = new Picture(PADDING, PADDING, resource[0]);
        } else {
            end = new Picture(PADDING, PADDING, resource[1]);
        }

        end.draw();
    }
}