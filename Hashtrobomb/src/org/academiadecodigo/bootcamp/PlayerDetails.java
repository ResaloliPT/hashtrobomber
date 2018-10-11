package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Objects.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class PlayerDetails {

    private int nrOfBombs;
    private int bombsPower;
    private String player1;
    private String player2;

    public PlayerDetails(Player player) {
        this.nrOfBombs = player.getMaxBombs();
        this.bombsPower = player.getBombPower();
        this.player1 = player.getName();
        this.player2 = player.getName();

        int v;
        int v1;

        if (player1.equals("Player1")) {
            v = 20;
            v1 = 20;

        } else {
            v = 60;
            v1 = 20;

        }

        Text text = new Text(v, v1, "BOMBS : " + nrOfBombs);
        text.setColor(Color.MAGENTA);
        text.draw();


    }


}
