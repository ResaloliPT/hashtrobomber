package org.academiadecodigo.bootcamp.Objects.Bomb;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Objects.Destroyable;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Objects.ObjectFactory;
import org.academiadecodigo.bootcamp.Objects.Player;
import org.academiadecodigo.bootcamp.Position.Directions;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Bomb extends GameObject implements Destroyable {

    private final int EXPLOSION_TIMER = 750;
    private int power;
    private int timer = 3000;
    private Player player;
    private Picture bomb;
<<<<<<< HEAD
    private List<Explosion> explosion = new LinkedList<>();
=======
    private List<Explosion> explosionList = new LinkedList<>();
>>>>>>> 0aba52c3b5ee23a61b8eaf10af6e78d2eba93b6f


    public Bomb(int col, int row, Player player, int power, Field field) {

        super(col, row, field);
        this.power = power;
        this.player = player;

        bomb = new Picture(position.getX(), position.getY(), "resources/bomb1.png");
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
        Game.gameObjects.remove(this);

<<<<<<< HEAD
        //explosion = new Explosion[1 + 4 * power];

        explosion.add(ObjectFactory.createExplosion(col, row, position.getField()));

        //int multiplier = 1;

        for (int i = 1; i <= power; i++) {

            explosion.add(ObjectFactory.createExplosion(col + i, row, position.getField()));
=======

        explosionList.add(ObjectFactory.createExplosion(col, row, position.getField()));

        for (int i = 1; i <= power; i++) {
            explosionList.add(ObjectFactory.createExplosion(col + i, row, position.getField()));
        }
        for (int i = 1; i <= power; i++) {
            explosionList.add(ObjectFactory.createExplosion(col - i, row, position.getField()));
        }
        for (int i = 1; i <= power; i++) {
            explosionList.add(ObjectFactory.createExplosion(col, row + i, position.getField()));
>>>>>>> 0aba52c3b5ee23a61b8eaf10af6e78d2eba93b6f
        }
        for (int i = 1; i <= power; i++) {
            explosionList.add(ObjectFactory.createExplosion(col, row - i, position.getField()));
        }


<<<<<<< HEAD

=======
        Game.gameObjects.remove(this);
>>>>>>> 0aba52c3b5ee23a61b8eaf10af6e78d2eba93b6f
        try {
            Thread.sleep(EXPLOSION_TIMER);
        } catch (InterruptedException ex) {

        }

        for (Explosion ex : explosionList) {
            ex.erase();
        }

        player.decreaseActiveBombs();
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
