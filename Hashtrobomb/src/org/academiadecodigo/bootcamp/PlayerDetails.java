package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Objects.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class PlayerDetails {

    private int nrOfBombs;
    private int bombsPower;
    private String playerName;

    public PlayerDetails(Player player) {
        this.nrOfBombs = player.getMaxBombs();
        this.bombsPower = player.getBombPower();
        this.playerName = player.getName();

    }

    public void updateP1Details() {

        Rectangle rectangle = new Rectangle(255,15,199,18);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();

        Text text0 = new Text(260, 15,playerName + "  BOMBS : " + nrOfBombs);
        text0.setColor(Color.BLUE);
        text0.draw();

        Text text1 = new Text(385, 15, "POWER : " + bombsPower);
        text1.setColor(Color.BLUE);
        text1.draw();


    }

    public void updateP2Details() {

        Rectangle rectangle = new Rectangle(255,660,199,18);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();

        Text text2 = new Text(260, 660,playerName + "  BOMBS : " + nrOfBombs);
        text2.setColor(Color.BLUE);
        text2.draw();

        Text text3 = new Text(385, 660, "POWER : " + bombsPower);
        text3.setColor(Color.BLUE);
        text3.draw();
    }
}
