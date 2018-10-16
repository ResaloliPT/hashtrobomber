package org.academiadecodigo.bootcamp.Objects.Bomb;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Music.Music;
import org.academiadecodigo.bootcamp.Objects.Destroyable;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Objects.ObjectFactory;
import org.academiadecodigo.bootcamp.Objects.Player;
import org.academiadecodigo.bootcamp.Objects.walls.Wall;
import org.academiadecodigo.bootcamp.configs.RenderConfigs;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Bomb extends GameObject implements Destroyable {
    private final int DELETE_EXPLOSION_TIMER = 500;
    private final int EXPLOSION_TIMER = 2300;
    private final int SOUND_TIMER = 1500;
    private Timer trigger = new Timer();
    private int power;
    private Player player;
    private Picture bomb;
    private List<Explosion> explosionList = new LinkedList<>();


    public Bomb(int col, int row, Player player, int power) {
        super(col, row);
        this.power = power;
        this.player = player;

        bomb = new Picture(position.getX(), position.getY(), RenderConfigs.BOMB_ITEM);
        bomb.draw();
        bombMusicTimer();
        timerTask();
    }


    public void bombMusicTimer() {
        TimerTask explode = new TimerTask() {
            public void run() {
                Music.startMusic(Music.MUSIC_BOMB_EXPLOSION, false);
            }
        };
        trigger.schedule(explode, SOUND_TIMER);
    }

    public void delete() {
        bomb.delete();
        Game.gameObjects.remove(this);
    }

    public void timerTask() {
        TimerTask explode = new TimerTask() {
            public void run() {
                explode();
            }
        };
        trigger.schedule(explode, EXPLOSION_TIMER);
    }

    public void explode() {

        int col = position.getCol();
        int row = position.getRow();

        String spriteFile;
        this.delete();

        explosionList.add(ObjectFactory.createExplosion(col, row, RenderConfigs.BOMB_CENTER));

        boolean rightStopped = false;
        boolean leftStopped = false;
        boolean downStopped = false;
        boolean upStopped = false;


        for (int i = 1; i <= power; i++) {
            GameObject[] objs = {
                    Game.objectAtPos(col - i, row), // LEFT
                    Game.objectAtPos(col + i, row), // RIGHT
                    Game.objectAtPos(col, row - 1), // UP
                    Game.objectAtPos(col, row + 1)  // Down

            };

            if (col - i >= Field.MIN_COL && !leftStopped) {
                if (i == power || objs[0] instanceof Destroyable) {

                    spriteFile = RenderConfigs.BOMB_LEFT_END;
                    leftStopped = true;

                } else {

                    spriteFile = RenderConfigs.BOMB_LEFT;
                }

                if (objs[0] instanceof Wall) {
                    leftStopped = true;
                } else {
                    explosionList.add(ObjectFactory.createExplosion(col - i, row, spriteFile));
                }
            }

            if (col + i <= Field.MAX_COL && !rightStopped) {
                if (i == power || objs[1] instanceof Destroyable) {

                    spriteFile = RenderConfigs.BOMB_RIGHT_END;
                    rightStopped = true;

                } else {

                    spriteFile = RenderConfigs.BOMB_RIGHT;
                }

                if (objs[1] instanceof Wall) {
                    rightStopped = true;
                } else {
                    explosionList.add(ObjectFactory.createExplosion(col + i, row, spriteFile));
                }
            }

            if (row - i >= Field.MIN_ROW && !upStopped) {
                if (i == power || objs[2] instanceof Destroyable || (Game.objectAtPos(col, row - 2) instanceof Wall || row - i < Field.MIN_ROW)) {

                    spriteFile = RenderConfigs.BOMB_UP_END;
                    upStopped = true;

                } else {

                    spriteFile = RenderConfigs.BOMB_UP;
                }

                if (objs[2] instanceof Wall) {
                    upStopped = true;
                } else {
                    explosionList.add(ObjectFactory.createExplosion(col, row - i, spriteFile));
                }
            }

            if (row + i <= Field.MAX_ROW && !downStopped) {
                if (i == power || objs[3] instanceof Destroyable) {

                    spriteFile = RenderConfigs.BOMB_DOWN_END;
                    downStopped = true;

                } else {

                    spriteFile = RenderConfigs.BOMB_DOWN;
                }

                if (objs[3] instanceof Wall) {
                    downStopped = true;
                } else {
                    explosionList.add(ObjectFactory.createExplosion(col, row + i, spriteFile));
                }
            }
        }

        for (Explosion explosion : explosionList) {

            GameObject obj = CollisionDetector.checkCollision(explosion);
            if (obj instanceof Destroyable) {
                ((Destroyable) obj).destroy();
            }
            if (Game.players[0] != null && explosion.getPosition().equals(Game.players[0].getPosition())) {
                Game.players[0].destroy();
            }
            if (Game.players[1] != null && explosion.getPosition().equals(Game.players[1].getPosition())) {
                Game.players[1].destroy();
            }
        }


        try {
            Thread.sleep(DELETE_EXPLOSION_TIMER);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
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
