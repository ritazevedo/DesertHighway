package org.codeforall.iorns;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private static final int PADDLE = 10;
    private Rectangle grid = new Rectangle(PADDLE,PADDLE,719,483);

    public Grid() {
        show();
    }

    public void show() {
        grid.draw();
    }

    public int getGridHight() {
        return grid.getHeight();
    }

    public int getGridWidth() {
        return grid.getWidth();
    }


}
