package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Menu.EndingMenu;
import org.academiadecodigo.bootcamp.Menu.MenuCountdown;
import org.academiadecodigo.bootcamp.Objects.GameObject;
import org.academiadecodigo.bootcamp.Objects.ObjectFactory;
import org.academiadecodigo.bootcamp.Objects.Player;
import org.academiadecodigo.bootcamp.Position.Directions;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.bootcamp.configs.RenderConfigs;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;
import java.util.List;

public class Game implements KeyboardHandler {
    private Field field;
    private Level level;
    public static Player[] players = new Player[2];
    private PlayerDetails[] pDetails = new PlayerDetails[2];
    private Keyboard keyboard = new Keyboard(this);
    public static List<GameObject> gameObjects = new LinkedList<>();

    public Game() {
        field = new Field();
        level = new Level(field);

        gameObjects = level.level1();

        players[0] = ObjectFactory.createPlayer("player1", 0, 0, RenderConfigs.PLAYER1_DOWN);
        players[1] = ObjectFactory.createPlayer("player2", 14, 14, RenderConfigs.PLAYER2_DOWN);

        //pDetails[0] = new PlayerDetails(players[0]);
        //pDetails[1] = new PlayerDetails(players[1]);

        keyBinding();
    }


    public void start() {

        MenuCountdown.showCountdown();

        while (!players[0].isDestroyed() && !players[1].isDestroyed()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.out.println("Error on menu loop.");
                ex.printStackTrace();
            }
        }
        Player winner = players[0].isDestroyed() ? players[1] : players[0];

        end();

        new EndingMenu(winner);

    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        if (players.length == 2) {
            int currentCol_p1 = players[0].getCol();
            int currentRow_p1 = players[0].getRow();
            int currentCol_p2 = players[1].getCol();
            int currentRow_p2 = players[1].getRow();

            switch (e.getKey()) {
                case KeyboardEvent.KEY_W:
                    players[0].setCharacter(RenderConfigs.PLAYER1_UP);
                    if (players[0].isMovementAvailable(new Position(currentCol_p1, currentRow_p1 - 1))) {
                        players[0].move(Directions.UP);
                    }
                    break;
                case KeyboardEvent.KEY_S:
                    players[0].setCharacter(RenderConfigs.PLAYER1_DOWN);
                    if (players[0].isMovementAvailable(new Position(currentCol_p1, currentRow_p1 + 1))) {
                        players[0].move(Directions.DOWN);
                    }
                    break;
                case KeyboardEvent.KEY_A:
                    players[0].setCharacter(RenderConfigs.PLAYER1_LEFT);
                    if (players[0].isMovementAvailable(new Position(currentCol_p1 - 1, currentRow_p1))) {
                        players[0].move(Directions.LEFT);
                    }
                    break;
                case KeyboardEvent.KEY_D:
                    players[0].setCharacter(RenderConfigs.PLAYER1_RIGHT);
                    if (players[0].isMovementAvailable(new Position(currentCol_p1 + 1, currentRow_p1))) {
                        players[0].move(Directions.RIGHT);
                    }
                    break;
                case KeyboardEvent.KEY_SPACE:
                    players[0].dropBomb();
                    gameObjects.add(ObjectFactory.createBomb(currentCol_p1, currentRow_p1, players[0], players[0].getBombPower()));
                    break;

                case KeyboardEvent.KEY_UP:
                    players[1].setCharacter(RenderConfigs.PLAYER2_UP);
                    if (players[1].isMovementAvailable(new Position(currentCol_p2, currentRow_p2 - 1))) {
                        players[1].move(Directions.UP);
                    }
                    break;
                case KeyboardEvent.KEY_DOWN:
                    players[1].setCharacter(RenderConfigs.PLAYER2_DOWN);
                    if (players[1].isMovementAvailable(new Position(currentCol_p2, currentRow_p2 + 1))) {
                        players[1].move(Directions.DOWN);
                    }
                    break;
                case KeyboardEvent.KEY_LEFT:
                    players[1].setCharacter(RenderConfigs.PLAYER2_LEFT);
                    if (players[1].isMovementAvailable(new Position(currentCol_p2 - 1, currentRow_p2))) {
                        players[1].move(Directions.LEFT);
                    }
                    break;
                case KeyboardEvent.KEY_RIGHT:
                    players[1].setCharacter(RenderConfigs.PLAYER2_RIGHT);
                    if (players[1].isMovementAvailable(new Position(currentCol_p2 + 1, currentRow_p2))) {

                        players[1].move(Directions.RIGHT);
                    }
                    break;
                case KeyboardEvent.KEY_L:
                    players[1].dropBomb();
                    gameObjects.add(ObjectFactory.createBomb(currentCol_p2, currentRow_p2, players[1], players[1].getBombPower()));
                    break;
                case KeyboardEvent.KEY_6:
                    players[1].destroy();

                    break;

                case KeyboardEvent.KEY_7:
                    players[0].destroy();

                    break;

            }
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

        KeyboardEvent special = new KeyboardEvent();
        special.setKey(KeyboardEvent.KEY_6);
        special.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(special);

        KeyboardEvent special1 = new KeyboardEvent();
        special1.setKey(KeyboardEvent.KEY_7);
        special1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(special1);

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

    public void end() {

        players = new Player[0];
        gameObjects.clear();
        field = new Field();
    }

    public static GameObject objectAtPos(int col, int row) {

        Position position = new Position(col, row);

        for (GameObject object : gameObjects) {
            if (position.getCol() == object.getCol() && position.getRow() == object.getRow()) {
                return object;
            }
        }
        return null;
    }

}
