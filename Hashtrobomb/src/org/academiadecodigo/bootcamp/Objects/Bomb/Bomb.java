package org.academiadecodigo.bootcamp.Objects.Bomb;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Menu.BombMusic;
import org.academiadecodigo.bootcamp.Objects.Destroyable;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Objects.ObjectFactory;
import org.academiadecodigo.bootcamp.Objects.Player;
import org.academiadecodigo.bootcamp.Objects.walls.Wall;
import org.academiadecodigo.simplegraphics.pictures.Picture;


import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Bomb extends GameObject implements Destroyable {
    private Timer trigger = new Timer();
    private final int DELETE_EXPLOSION_TIMER = 500;
    private int power;
    private final int EXPLOSION_TIMER = 2300;
    private final int SOUND_TIMER = 2000;
    private Player player;
    private Picture bomb;
    private List<Explosion> explosionList = new LinkedList<>();

    BombMusic bombMusic = new BombMusic();

    public Bomb(int col, int row, Player player, int power, Field field) {

        super(col, row, field);
        this.power = power;
        this.player = player;

        bomb = new Picture(position.getX(), position.getY(), "resources/bomb.png");
        bomb.draw();
        bombMusicTimer();
        timerTask();
    }

    public void bombAnimation() {

        for (int i = 0; i < 4; i++) {
            bomb.grow(i, i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void bombMusicTimer() {
        TimerTask explode = new TimerTask() {
            public void run() {
                bombMusic.startMusic();
            }
        };
       // Timer trigger = new Timer();
        trigger.schedule(explode, SOUND_TIMER);
    }

    public void delete() {
        Game.gameObjects.remove(this);
        bomb.delete();
    }

    public void timerTask() {
        TimerTask explode = new TimerTask() {
            public void run() {
                explode();
            }
        };
        //Timer trigger = new Timer();
        trigger.schedule(explode, EXPLOSION_TIMER);
    }

    public void explode() {

//        bombAnimation();
        bombMusic.startMusic();
        int col = position.getCol();
        int row = position.getRow();
        String spriteFile;
        this.delete();

        explosionList.add(ObjectFactory.createExplosion(col, row, position.getField(), "resources/explosion_center.png"));

        for (int i = 1; i <= power; i++) {
            if (col + i <= Field.getMaxCol()) {
                GameObject obj = Game.objectAtPos(col + i, row, position.getField());
                spriteFile = i == power ? "resources/explosion_right_end.png" : "resources/explosion_right_middle.png";
                if (!CollisionDetector.checkCollision(col + i, row, position.getField()) || obj instanceof Explosion) {
                    explosionList.add(ObjectFactory.createExplosion(col + i, row, position.getField(), spriteFile));
                    continue;
                }
                if (!(obj instanceof Wall)) {
                    explosionList.add(ObjectFactory.createExplosion(col + i, row, position.getField(), "resources/explosion_right_end.png"));
                    break;
                }
            }
            break;
        }
        for (int i = 1; i <= power; i++) {
            if (col - i >= Field.getMinCol()) {
                GameObject obj = Game.objectAtPos(col - i, row, position.getField());
                spriteFile = i == power ? "resources/explosion_left_end.png" : "resources/explosion_left_middle.png";
                if (!CollisionDetector.checkCollision(col - i, row, position.getField()) || obj instanceof Explosion) {
                    explosionList.add(ObjectFactory.createExplosion(col - i, row, position.getField(), spriteFile));
                    continue;
                }
                if (!(Game.objectAtPos(col - i, row, position.getField()) instanceof Wall)) {
                    explosionList.add(ObjectFactory.createExplosion(col - i, row, position.getField(), "resources/explosion_left_end.png"));
                    break;
                }
            }
            break;
        }
        for (int i = 1; i <= power; i++) {
            if (row + i <= Field.getMaxRow()) {
                GameObject obj = Game.objectAtPos(col , row + i, position.getField());
                spriteFile = i == power ? "resources/explosion_down_end.png" : "resources/explosion_down_middle.png";
                if (!CollisionDetector.checkCollision(col, row + i, position.getField()) || obj instanceof Explosion) {
                    explosionList.add(ObjectFactory.createExplosion(col, row + i, position.getField(), spriteFile));
                    continue;
                }
                if (!(Game.objectAtPos(col, row + i, position.getField()) instanceof Wall)) {
                    explosionList.add(ObjectFactory.createExplosion(col, row + i, position.getField(), "resources/explosion_down_end.png"));
                    break;
                }
            }
            break;
        }
        for (int i = 1; i <= power; i++) {
            if (row - i >= Field.getMinRow()) {
                GameObject obj = Game.objectAtPos(col, row - i, position.getField());
                spriteFile = i == power ? "resources/explosion_up_end.png" : "resources/explosion_up_middle.png";
                if (!CollisionDetector.checkCollision(col, row - i, position.getField()) || obj instanceof Explosion) {
                    explosionList.add(ObjectFactory.createExplosion(col, row - i, position.getField(), spriteFile));
                    continue;
                }
                if (!(Game.objectAtPos(col, row - i, position.getField()) instanceof Wall)) {
                    explosionList.add(ObjectFactory.createExplosion(col, row - i, position.getField(), "resources/explosion_up_end.png"));
                    break;
                }
            }
            break;
        }

        for (Explosion explosion : explosionList) {
            GameObject obj = CollisionDetector.checkCollision(explosion);
            if (CollisionDetector.checkCollision(explosion) instanceof Destroyable) {
                ((Destroyable) obj).destroy();
            }
            if(explosion.getPosition().equals(Game.players[0].getPosition())){
                Game.players[0].destroy();
            }
            if(explosion.getPosition().equals(Game.players[1].getPosition())){
                Game.players[1].destroy();
            }
        }


        try {
            Thread.sleep(DELETE_EXPLOSION_TIMER);
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
