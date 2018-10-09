package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Menu.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        try{
            menu.start();
        }catch (InterruptedException e){

        }

        Game game = new Game();
        game.init();
        game.start();
    }
}
