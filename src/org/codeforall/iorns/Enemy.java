package org.codeforall.iorns;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.codeforall.iorns.EventHandlerStart.gameEnded;
import static org.codeforall.iorns.EventHandlerStart.gameStarted;

public class Enemy {

    private Picture[] enemies;
    private Picture enemy;
    private int x;
    private int y;
    private boolean enemyShowed;
    private Car car;
    private boolean isOnScreen = false;

    public Enemy(Car car) {
        enemies = new Picture[6];
        this.car = car;
    }

    public void createEnemies() {
        enemies[0] = new Picture(540, 130, "resources/car2.png");
        enemies[1] = new Picture(540, 130, "resources/car3.png");
        enemies[2] = new Picture(580, 130, "resources/car2.png");
        enemies[3] = new Picture(580, 130, "resources/car3.png");
        enemies[4] = new Picture(620, 130, "resources/car2.png");
        enemies[5] = new Picture(620, 130, "resources/car3.png");
    }

    public void enemyGrowing() {
        enemy.grow(-240, -240);
        enemy.draw();
    }

    public void generateEnemies() {
        createEnemies();
        enemyShowed = true;
        int number = (int) Math.ceil(Math.random() * 6);
        switch (number) {
            case 1:
                enemy = enemies[0];
                enemyGrowing();
                break;
            case 2:
                enemy = enemies[1];
                enemyGrowing();
                break;
            case 3:
                enemy = enemies[2];
                enemyGrowing();
                break;
            case 4:
                enemy = enemies[3];
                enemyGrowing();
                break;
            case 5:
                enemy = enemies[4];
                enemyGrowing();
                break;
            case 6:
                enemy = enemies[5];
                enemyGrowing();
                break;
        }
    }

    public void enemyWalk() {
        x = enemy.getX();
        y = enemy.getY();
        position1();
        position2();
        position3();
        position4();
        position5();
    }

    public void position1() {
        if (x == 780 && y == 370) {
            enemy.translate(-1, 80);
        }
        if (x == 820 && y == 370) {
            enemy.translate(0, 80);
        }
        if (x == 860 && y == 370) {
            enemy.translate(1, 80);
        }
    }

    public void position2() {
        if (x == 779 && y == 450) {
            enemy.grow(20, 20);
            enemy.translate(-10, 100);
        }
        if (x == 820 && y == 450) {
            enemy.grow(20, 20);
            enemy.translate(0, 100);
        }
        if (x == 861 && y == 450) {
            enemy.grow(20, 20);
            enemy.translate(10, 100);
        }
    }

    public void position3() {
        if (x == 749 && y == 530) {
            enemy.grow(35, 35);
            enemy.translate(-50, 120);
        }
        if (x == 800 && y == 530) {
            enemy.grow(35, 35);
            enemy.translate(0, 120);
        }
        if (x == 851 && y == 530) {
            enemy.grow(35, 35);
            enemy.translate(50, 120);
        }
    }

    public void position4() {
        if (x == 664 && y == 615) {
            enemy.grow(180, 180);
            enemy.translate(-180, 170);
        }
        if (x == 765 && y == 615) {
            enemy.grow(180, 180);
            enemy.translate(0, 170);
        }
        if (x == 866 && y == 615) {
            enemy.grow(180, 180);
            enemy.translate(180, 170);
        }
    }

    public void position5() {
        if (x == 304 && y == 605) {
            if (car.getCarX() == 300 && car.getCarY() == 600) {
                gameEnded = true;
                gameStarted = false;
                return;
            }
            enemy.delete();
        }
        if (x == 585 && y == 605) {
            if (car.getCarX() == 580 && car.getCarY() == 600) {
                gameEnded = true;
                gameStarted = false;
                return;
            }
            enemy.delete();
        }
        if (x == 866 && y == 605) {
            if (car.getCarX() == 860 && car.getCarY() == 600) {
                gameEnded = true;
                gameStarted = false;
                return;
            }
            enemy.delete();
        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isEnemyShowed() {
        return enemyShowed;
    }

    public void deleteEnemy() {
        enemy.delete();
    }

}
