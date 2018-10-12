package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Objects.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class PlayerDetails {

    public PlayerDetails(Player[] players) {

        updateP1Details(players[0]);
        updateP2Details(players[1]);
    }

    public void updateP1Details(Player player) {

        Rectangle rectangle = new Rectangle(255,15,199,18);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();

        Text text0 = new Text(260, 15,player.getName() + "  BOMBS : " + player.getMaxBombs());
        text0.setColor(Color.BLUE);
        text0.draw();

        Text text1 = new Text(385, 15, "POWER : " + player.getBombPower());
        text1.setColor(Color.BLUE);
        text1.draw();


    }

    public void updateP2Details(Player player) {

        Rectangle rectangle = new Rectangle(255,660,199,18);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();

        Text text2 = new Text(260, 660,player.getName() + "  BOMBS : " + player.getMaxBombs());
        text2.setColor(Color.BLUE);
        text2.draw();

        Text text3 = new Text(385, 660, "POWER : " + player.getBombPower());
        text3.setColor(Color.BLUE);
        text3.draw();
    }
}
