package org.codeforall.iorns;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.codeforall.iorns.EventHandlerStart.gameEnded;
import static org.codeforall.iorns.EventHandlerStart.gameStarted;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Background {

    Picture[] pictures;
    private Car car;
    private Enemy enemy;
    private int counter;
    private Picture gameOver;
    public static Sound runSound;


    public Background() {
        pictures = new Picture[9];
        car = new Car();
        enemy = new Enemy(car);
        gameOver = new Picture(670, 220, "resources/gameover.png");
        runSound = new Sound("/resources/sound/runmusic.wav");
    }

    public Picture[] createPictures() {
        pictures[0] = new Picture(10, 10, "resources/background1.png");
        pictures[1] = new Picture(10, 10, "resources/background2.png");
        pictures[2] = new Picture(10, 10, "resources/background3.png");
        pictures[3] = new Picture(10, 10, "resources/background4.png");
        pictures[4] = new Picture(10, 10, "resources/background5.png");
        pictures[5] = new Picture(10, 10, "resources/background6.png");
        pictures[6] = new Picture(10, 10, "resources/background7.png");
        pictures[7] = new Picture(10, 10, "resources/background8.png");
        pictures[8] = new Picture(10, 10, "resources/background9.png");
        return pictures;
    }


    public void changeBackground()  {
        if (gameStarted) {
            runSound.play();
            gameOver.delete();
            car.deleteCar();
            car.drawCar();
            for (int i = 0; i < pictures.length + 1; i++) {
                if (i == pictures.length) {
                    i = -1;
                    continue;
                }
                pictures[i].draw();
                counter++;
                if (counter == 5) {
                    enemy.generateEnemies();
                    counter = 0;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (enemy.isEnemyShowed()) {
                    enemy.enemyWalk();
                }
                pictures[i].delete();
                if (gameEnded) {
                    car.deleteCar();
                    enemy.deleteEnemy();
                    gameOver.draw();
                    return;
                }
            }
        }
    }

    public void createBackground() {
        createPictures();
        car.init();
        changeBackground();
    }


}
