package com.akivayoni;

import com.akivayoni.display.Window;
import com.akivayoni.gameloop.GameLoopTimer;
import com.akivayoni.gameloop.Renderable;

public class Main {

    public static void main(String[] args) {
        Window window = new Window("Cell Machine");
        window.showWindow();

        Renderable renderable = elapsedTime -> {
            // render
            window.show();
            window.clearScreen();
        };

        GameLoopTimer timer = new GameLoopTimer(60, renderable);
        timer.start();
    }
}
