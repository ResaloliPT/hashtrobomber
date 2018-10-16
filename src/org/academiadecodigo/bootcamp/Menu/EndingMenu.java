package org.academiadecodigo.bootcamp.Menu;

import org.academiadecodigo.bootcamp.Objects.Player;
import org.academiadecodigo.bootcamp.configs.RenderConfigs;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class EndingMenu {

    private static final int PADDING = 10;
    private Picture end;


    public EndingMenu(Player winner) {

        if (winner.getName().equals("player1")) {
            end = new Picture(PADDING, PADDING, RenderConfigs.ENDGAME_1);
        } else {
            end = new Picture(PADDING, PADDING, RenderConfigs.ENDGAME_2);
        }

        end.draw();
    }
}