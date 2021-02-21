package com.akivayoni;

import com.akivayoni.display.BoardRenderer;
import com.akivayoni.display.Window;
import com.akivayoni.gameloop.GameLoopTimer;
import com.akivayoni.gameloop.Renderable;

public class Main {

    public static void main(String[] args) {
        Window window = new Window("Cell Machine");
        window.showWindow();
        int[][] testing = {
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
                {1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1},
                {1, 1, 3, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
                {1, 1, 1, 4, 1, 6, 1, 1, 1, 1, 1, 5, 1, 1},
                {1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1},
                {1, 1, 3, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
                {1, 1, 1, 4, 1, 6, 1, 1, 1, 1, 1, 5, 1, 1},
                {1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 5, 1, 1}
        };

        Renderable renderable = elapsedTime -> {
            // render
            BoardRenderer.render(testing, window.getDrawingGraphics());
            window.show();
            window.clearScreen();
        };

        GameLoopTimer timer = new GameLoopTimer(60, renderable);
        timer.start();
    }
}
