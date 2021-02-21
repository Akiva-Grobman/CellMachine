package com.akivayoni.gameloop;

/*
*     This represents a game loop object.
*     This class will be initialized to run at a predetermined FPS(frames per second),
*     as well as a method to execute each time it refreshes.
*/

public class GameLoopTimer {

    private final int FPS;
    private final Renderable renderable;
    private boolean run;

    public GameLoopTimer(int fps, Renderable renderable) {
        FPS = fps;
        this.renderable = renderable;
        run = false;
    }

    public void start() {
        run = true;
        double timePerUpdate = 1000000000f / FPS;
        double timeFromLastUpdate = 0;
        double previousTime = System.nanoTime();
        double currentTime;
        while (run) {
            currentTime  = System.nanoTime();
            timeFromLastUpdate += (currentTime - previousTime) / timePerUpdate;
            previousTime = currentTime;
            if(timeFromLastUpdate >= 1) {
                timeFromLastUpdate--;
                renderable.tick(timeFromLastUpdate);
            }
        }
    }

    public void stop() {
        run = false;
    }

}
