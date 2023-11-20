package org.codeforall.iorns;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.codeforall.iorns.EventHandlerStart.gameEnded;

public class Main {

    public static void main(String[] args) {


        Picture picture = new Picture(10, 10, "resources/background.png");
        picture.draw();

        Picture logo = new Picture(10, 10, "resources/gamelogo.png");
        logo.draw();


        EventHandlerStart eventHandlerStart = new EventHandlerStart(logo);
        Car car = new Car();
        car.deleteCar();
        eventHandlerStart.init();
        eventHandlerStart.gameOver();
        if (gameEnded) {
            car.deleteCar();
        }

    }

}
