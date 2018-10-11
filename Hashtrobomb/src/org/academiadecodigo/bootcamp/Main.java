package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Menu.Menu;
import org.academiadecodigo.bootcamp.Menu.MenuInstructions;

public class Main {
    public static void main(String[] args) {


        Menu menu = new Menu();

        try {
            menu.start();
        } catch (InterruptedException e) {

        }

        MenuInstructions inst = new MenuInstructions();
        try {
            inst.start();
        }catch (InterruptedException i){

        }


        Game game = new Game();
        game.start();
    }
}
