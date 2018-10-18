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

    public MenuInstructions() {
        inst = new Picture(PADDING, PADDING, RenderConfigs.INSTRUCTIONS);
        inst.draw();

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
        inst.delete();
        Music.startMusic(Music.MUSIC_BG, true);
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

