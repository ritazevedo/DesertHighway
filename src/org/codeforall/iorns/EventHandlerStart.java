package org.codeforall.iorns;


import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import static org.codeforall.iorns.Background.runSound;


public class EventHandlerStart implements KeyboardHandler {

    public static boolean gameStarted;
    public static boolean gameEnded;
    private Picture logo;
    private Picture gameOver;
    private int count;
    public static Sound countdown;


    public EventHandlerStart(Picture logo) {
        this.logo = logo;
        countdown = new Sound("/resources/sound/countdown.wav");
    }

    public void init() {
        Keyboard kb = new Keyboard(this);

        KeyboardEvent startEvent = new KeyboardEvent();
        startEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        startEvent.setKey(KeyboardEvent.KEY_SPACE);

        KeyboardEvent restartEvent = new KeyboardEvent();
        restartEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        restartEvent.setKey(KeyboardEvent.KEY_ENTER);

        kb.addEventListener(startEvent);
        kb.addEventListener(restartEvent);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                if (!gameStarted) {
                    if (count == 1) {
                        return;
                    }
                    new Thread(new CountdownSequence()).start();
                    gameStarted = true;
                    gameEnded = false;
                    count++;
                }
                break;
            case KeyboardEvent.KEY_ENTER:
                if (!gameStarted) {
                    Picture picture = new Picture(10, 10, "resources/background.png");
                    picture.draw();
                    runSound.stop();
                    new Thread(new CountdownSequence()).start();
                    countdown.reOpen();
                    countdown.play();
                    gameStarted = true;
                    gameEnded = false;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public void gameOver() {
        if (gameEnded) {
            gameOver = new Picture(820, 170, "resources/gameover.png");
            gameOver.draw();
        }
    }

    private class CountdownSequence implements Runnable {

        @Override
        public void run() {
            Background background = new Background();
            Picture start = new Picture(825, 170, "resources/red.png");
            try {
                logo.delete();
                start.draw();
                countdown.play();
                Thread.sleep(1000);
                start.load("resources/yellow.png");
                Thread.sleep(1000);
                start.load("resources/green.png");
                Thread.sleep(1500);
                start.delete();
                countdown.close();
                background.createBackground();
                Car car = new Car();
                car.drawCar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}