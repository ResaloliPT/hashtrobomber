package org.academiadecodigo.bootcamp.Menu;

import org.academiadecodigo.bootcamp.Music.Music;
import org.academiadecodigo.bootcamp.configs.RenderConfigs;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class MenuInstructions implements KeyboardHandler {

    private static final int PADDING = 10;
    private boolean exitInst;
    private Picture inst;
    private Keyboard keyboard = new Keyboard(this);
    private Picture three;
    private Picture two;
    private Picture one;

    public MenuInstructions() {
        inst = new Picture(PADDING, PADDING, RenderConfigs.INSTRUCTIONS);
        inst.draw();

        one = new Picture(PADDING, PADDING, RenderConfigs.COUNTDOWN_1);
        two = new Picture(PADDING, PADDING, RenderConfigs.COUNTDOWN_2);
        three = new Picture(PADDING, PADDING, RenderConfigs.COUNTDOWN_3);

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
                Music.startMusic(Music.MUSIC_BG, true);

                three.draw();

                Thread.sleep(900);

                two.draw();
                three.delete();

                Thread.sleep(900);

                one.draw();
                two.delete();

                Thread.sleep(900);

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

