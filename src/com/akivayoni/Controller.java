package com.akivayoni;

import java.awt.*;

public class Controller {

    private static Controller instance = null;

    private Controller() {}

    public static Controller getInstance() {
        if(instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void tick() {

    }

    public void render(Graphics graphics, double elapsedTime) {

    }

}
