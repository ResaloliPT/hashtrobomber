package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Menu.Menu;
import org.academiadecodigo.bootcamp.Menu.MenuInstructions;
import org.academiadecodigo.bootcamp.configs.RenderConfigs;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        MenuInstructions inst = new MenuInstructions();
        Game game = new Game();

        menu.start();
        inst.start();
        game.start();
    }
}
