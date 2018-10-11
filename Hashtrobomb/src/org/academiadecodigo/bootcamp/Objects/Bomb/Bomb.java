package org.academiadecodigo.bootcamp.Objects.Bomb;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Objects.Destroyable;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Objects.ObjectFactory;
import org.academiadecodigo.bootcamp.Objects.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Timer;
import java.util.TimerTask;


public class Bomb extends GameObject implements Destroyable {

    private final int EXPLOSION_TIMER = 750;
    private int power;
    private int timer = 3000;
    private Player player;
    private Picture bomb;
    private Explosion[] explosion;


    public Bomb(int col, int row, Player player, int power, Field field) {

        super(col, row, field);
        this.power = power;
        this.player = player;

        bomb = new Picture(position.getX(), position.getY(), "resources/bomb.png");
        bomb.draw();
        timerTask();


    }


    public void timerTask() {
        TimerTask explode = new TimerTask() {
            public void run() {
                explode();
            }
        };
        Timer trigger = new Timer();
        trigger.schedule(explode, timer);
    }

    public void explode() {

        int col = position.getCol();
        int row = position.getRow();

        bomb.delete();

        explosion = new Explosion[1 + 4 * power];
        explosion[0] = ObjectFactory.createExplosion(col, row, position.getField());

        int multiplier = 1;

        for (int i = 1; i <= power; i++) {

            explosion[multiplier] = ObjectFactory.createExplosion(col + i, row, position.getField());
            explosion[multiplier+1] = ObjectFactory.createExplosion(col - i, row, position.getField());
            explosion[multiplier+2] = ObjectFactory.createExplosion(col, row + i, position.getField());
            explosion[multiplier+3] = ObjectFactory.createExplosion(col, row - i, position.getField());

            multiplier += 4;
        }

        try {
            Thread.sleep(EXPLOSION_TIMER);
        } catch (InterruptedException ex){

        }

        for(Explosion ex: explosion) {
            ex.erase();
        }

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
