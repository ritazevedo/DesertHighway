package org.codeforall.iorns;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Car implements KeyboardHandler {

    private Picture car;
    private boolean canMoveRight = true;
    private boolean canMoveLeft = true;


    public Car() {
        car = new Picture(580, 600, "resources/car1.png");
        car.draw();
    }

    public void init() {

        Keyboard kb = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);

        kb.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        kb.addEventListener(left);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (canMoveLeft) {
                    car.translate(-280, 0);
                    if (car.getX() <= 300) {
                        canMoveLeft = false;
                        canMoveRight =true;

                    } else {
                        canMoveLeft = true;
                        canMoveRight =true;
                    }
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (canMoveRight) {
                    car.translate(280, 0);
                    if (car.getMaxX() >= 1300) {
                        canMoveRight = false;
                        canMoveLeft = true;

                    } else {
                        canMoveRight = true;
                        canMoveLeft = true;
                    }
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public void drawCar() {
        car.draw();
    }

    public void deleteCar() {
        car.delete();
    }

    public int getCarX() {
        return car.getX();
    }

    public int getCarY() {
        return car.getY();
    }

}
