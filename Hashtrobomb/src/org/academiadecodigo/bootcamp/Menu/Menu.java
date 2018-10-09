package org.academiadecodigo.bootcamp.Menu;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Menu implements KeyboardHandler {

    private boolean startGame;
    private String[] resource = {"resources/bk.png", "resources/button.png"};
    private static final int PADDING = 10;
    private Picture bg;
    private Picture play;
    private Keyboard keyboard = new Keyboard(this);

    public Menu() {
        bg = new Picture(PADDING, PADDING, resource[0]);
        bg.draw();
        play = new Picture(140, 300, resource[1]);
        play.draw();

        KeyboardEvent g = new KeyboardEvent();
        g.setKey(KeyboardEvent.KEY_SPACE);
        g.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(g);
    }


    public void start() throws InterruptedException {

        bg.draw();
        play.draw();
        while (!startGame) {
            play.grow(10, 10);
            Thread.sleep(300);
            play.grow(-10,-10);
            Thread.sleep(300);
        }
        play.delete();
        bg.delete();
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {

            case KeyboardEvent.KEY_SPACE:
                startGame = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
