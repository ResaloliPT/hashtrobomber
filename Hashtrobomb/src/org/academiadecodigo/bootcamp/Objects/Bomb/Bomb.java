package org.academiadecodigo.bootcamp.Objects.Bomb;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Objects.Destroyable;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Objects.Player;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Timer;
import java.util.TimerTask;


public class Bomb extends GameObject implements Destroyable {

    private int power;
    private int timer = 3000;
    private Player player;
    private Picture bomb;

    public Bomb(int col, int row, Player player, int power, Field field) {
        this.power = power;
        this.player = player;
        position = new Position(col, row, field);

        bomb = new Picture(position.getX(), position.getY(), "resources/bomb1.png");
        bomb.draw();

        TimerTask explode = new TimerTask() {
            public void run() {
                explode();
            }
        };
        Timer trigger = new Timer();
        trigger.schedule(explode, timer);
    }

    public void explode() {
        bomb.delete();
        player.decreaseActiveBombs();
        Game.gameObjects.remove(this);
    }

    @Override
    public void destroy() {
        destroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }
}
