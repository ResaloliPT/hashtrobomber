package org.academiadecodigo.bootcamp.Menu;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.configs.RenderConfigs;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MenuCountdown {

    private static Picture one = new Picture(Field.PADDING, Field.PADDING, RenderConfigs.COUNTDOWN_1);
    private static Picture two = new Picture(Field.PADDING, Field.PADDING, RenderConfigs.COUNTDOWN_2);
    private static Picture three = new Picture(Field.PADDING, Field.PADDING, RenderConfigs.COUNTDOWN_3);

    public static void showCountdown() {
        try {
            three.draw();

            Thread.sleep(900);

            two.draw();
            three.delete();

            Thread.sleep(900);

            one.draw();
            two.delete();

            Thread.sleep(900);

            one.delete();
        } catch (InterruptedException ex) {
            System.out.println("Error on Instructions loop.");
            ex.printStackTrace();
        }
    }
}
