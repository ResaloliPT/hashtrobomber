package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Menu.Menu;
import org.academiadecodigo.bootcamp.Menu.MenuInstructions;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.start();


        MenuInstructions inst = new MenuInstructions();
        inst.start();

        Game game = new Game();
        game.start();
    }
}
