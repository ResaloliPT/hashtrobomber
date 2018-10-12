package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Menu.Menu;
import org.academiadecodigo.bootcamp.Menu.MenuInstructions;
import org.academiadecodigo.bootcamp.Music.Music;

public class Main {
    public static void main(String[] args) {


        Menu menu = new Menu();


        try {

            menu.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MenuInstructions inst = new MenuInstructions();
        try {

            inst.start();

        } catch (InterruptedException i) {
            i.printStackTrace();
        }
        Game game = new Game();

        try {

            game.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
