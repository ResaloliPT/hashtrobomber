package org.academiadecodigo.bootcamp.Music;

import org.academiadecodigo.bootcamp.Main;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Music {

    public static final String MUSIC_BG = "/resources/sounds/music.wav";
    public static final String MUSIC_BOMB_EXPLOSION = "/resources/sounds/bombExplosion.wav";

    public static void startMusic(String musicPath, boolean loop) {
        URL soundURL;
        AudioInputStream audioInputStream = null;
        try {
            soundURL = Main.class.getResource(musicPath);
            if (soundURL == null) {
                musicPath = musicPath.substring(1);
                File file = new File(musicPath);
                soundURL = file.toURI().toURL();
            }
            audioInputStream = AudioSystem.getAudioInputStream(soundURL);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            if (loop) {
                clip.loop(clip.LOOP_CONTINUOUSLY);
            }

            Frame[] frames = Frame.getFrames();

            for (Frame frame : frames) {
                frame.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {

                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        clip.stop();
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {

                    }

                    @Override
                    public void windowIconified(WindowEvent e) {

                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {

                    }

                    @Override
                    public void windowActivated(WindowEvent e) {

                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {

                    }
                });
            }

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



