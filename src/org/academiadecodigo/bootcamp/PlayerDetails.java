package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Objects.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class PlayerDetails {

    private int bombsPower;
    private String playerName;
    private int activeBombs;
    private int maxBombs;

    public PlayerDetails(Player player) {
        this.activeBombs = player.getActiveBombs();
        this.maxBombs = player.getMaxBombs();
        this.bombsPower = player.getBombPower();
        this.playerName = player.getName();

    }

    public void updateDetails() {

        Rectangle rectangle = new Rectangle(255, 15, 199, 18);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();

        Text text0 = new Text(260, 15, playerName + "  BOMBS : " + (maxBombs - activeBombs) + " / " + maxBombs);
        text0.setColor(Color.BLUE);
        text0.draw();

        Text text1 = new Text(385, 15, "POWER : " + bombsPower);
        text1.setColor(Color.BLUE);
        text1.draw();
    }
}