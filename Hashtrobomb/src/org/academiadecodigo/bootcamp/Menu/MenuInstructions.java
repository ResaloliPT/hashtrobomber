package org.academiadecodigo.bootcamp.Menu;

import org.academiadecodigo.bootcamp.Music.InGameMusic;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class MenuInstructions implements KeyboardHandler {

    private static final int PADDING = 10;
    private boolean exitInst;
    private String[] resource = {"resources/menuinstructions.jpg", "resources/1.jpg", "resources/2.jpg", "resources/3.jpg",};
    private Picture inst;
    private Keyboard keyboard = new Keyboard(this);
    private Picture three;
    private Picture two;
    private Picture one;

    InGameMusic inGameMusic = new InGameMusic();

    public MenuInstructions() {
        inst = new Picture(PADDING, PADDING, resource[0]);
        inst.draw();

        one = new Picture(PADDING, PADDING, resource[1]);
        two = new Picture(PADDING, PADDING, resource[2]);
        three = new Picture(PADDING, PADDING, resource[3]);

        KeyboardEvent startGame = new KeyboardEvent();
        startGame.setKey(KeyboardEvent.KEY_SPACE);
        startGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(startGame);
    }


    public void start() {

        inst.draw();
        while (!exitInst) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.out.println("Error on Instructions loop.");
                ex.printStackTrace();
            }
        }

        while (exitInst) {

            try {
                inst.delete();
                inGameMusic.startMusic();

                three.draw();
                Thread.sleep(600);
                three.delete();

                Thread.sleep(300);

                two.draw();
                Thread.sleep(600);
                two.delete();

                Thread.sleep(300);

                one.draw();
                Thread.sleep(600);
                one.delete();
                break;
            } catch (InterruptedException ex) {
                System.out.println("Error on Instructions loop.");
                ex.printStackTrace();
            }

        }


    }

    @Override
    public void keyPressed(KeyboardEvent i) {

        switch (i.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                exitInst = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

