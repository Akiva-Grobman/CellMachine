package com.akivayoni.gameloop;

/*
*       This will be used to contain the logic that should be executed by the game loop
*/

public interface Renderable {

    // update
    // we pass the time that has elapsed from the last update
    void tick(double elapsedTime);

}
