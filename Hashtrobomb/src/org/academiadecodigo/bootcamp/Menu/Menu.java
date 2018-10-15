package org.academiadecodigo.bootcamp.Menu;

import org.academiadecodigo.bootcamp.configs.RenderConfigs;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Menu implements KeyboardHandler {

    private static final int PADDING = 10;
    private boolean startGame;
    private Picture bg;
    private Picture play;
    private Keyboard keyboard = new Keyboard(this);

    public Menu() {
        Picture myPic = new Picture(0, 0, RenderConfigs.STARTBG);
        myPic.draw();


        bg = new Picture(PADDING, PADDING, RenderConfigs.INITIALMENU);
        play = new Picture(44, 650, RenderConfigs.SPACEBAR);

        KeyboardEvent g = new KeyboardEvent();
        g.setKey(KeyboardEvent.KEY_SPACE);
        g.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(g);
    }


    public void start() {

        bg.draw();
        play.draw();

        while (!startGame) {
            try {
                play.grow(4, 6);
                Thread.sleep(300);
                play.grow(-4,-6);
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                System.out.println("Error on menu loop.");
                ex.printStackTrace();
            }

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
