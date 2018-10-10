package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Objects.ObjectFactory;
import org.academiadecodigo.bootcamp.Objects.Player;
import org.academiadecodigo.bootcamp.Position.Directions;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {
    private Field field;
    private Level level;
    private Player[] players = new Player[2];
    private Keyboard keyboard = new Keyboard(this);

    public Game() {
        keyBinding();



    }

    public void init() {
        field = new Field();
        level = new Level(field);
        level.level2();
        players[0] = ObjectFactory.createPlayer("Player 1", 0, 0, field, 0);
        players[1] = ObjectFactory.createPlayer("Player 2", 14, 14, field, 1);
    }

    public void start() {

    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {


            case KeyboardEvent.KEY_W:
                players[0].move(Directions.UP);
                break;
            case KeyboardEvent.KEY_S:
                players[0].move(Directions.DOWN);
                break;
            case KeyboardEvent.KEY_A:
                players[0].move(Directions.LEFT);
                break;
            case KeyboardEvent.KEY_D:
                players[0].move(Directions.RIGHT);
                break;
            case KeyboardEvent.KEY_SPACE:
                players[0].dropBomb();
                break;

            case KeyboardEvent.KEY_UP:
                players[1].move(Directions.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                players[1].move(Directions.DOWN);
                break;
            case KeyboardEvent.KEY_LEFT:
                players[1].move(Directions.LEFT);
                break;
            case KeyboardEvent.KEY_RIGHT:
                players[1].move(Directions.RIGHT);
                break;
            case KeyboardEvent.KEY_L:
                players[1].dropBomb();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void keyBinding() {
        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_S);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);

        KeyboardEvent up1 = new KeyboardEvent();
        up1.setKey(KeyboardEvent.KEY_UP);
        up1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up1);

        KeyboardEvent down1 = new KeyboardEvent();
        down1.setKey(KeyboardEvent.KEY_DOWN);
        down1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down1);

        KeyboardEvent left1 = new KeyboardEvent();
        left1.setKey(KeyboardEvent.KEY_LEFT);
        left1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left1);

        KeyboardEvent right1 = new KeyboardEvent();
        right1.setKey(KeyboardEvent.KEY_RIGHT);
        right1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right1);

        KeyboardEvent l = new KeyboardEvent();
        l.setKey(KeyboardEvent.KEY_L);
        l.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(l);
    }

}
