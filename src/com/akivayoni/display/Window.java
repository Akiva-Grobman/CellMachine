package com.akivayoni.display;

import javax.swing.*;
import java.awt.*;

public class Window {

    private static final int RESIZE_FACTOR = 75;
    public static final int WIDTH = 19 * RESIZE_FACTOR;
    public static final int HEIGHT = 12 * RESIZE_FACTOR;
    private final Canvas screen;
    private final JFrame window;

    public Window(String title) {
        window = new JFrame(title);
        screen = new Canvas();
        Dimension screenSize = new Dimension(WIDTH, HEIGHT);
        window.setSize(screenSize);
        screen.setPreferredSize(screenSize);
        screen.setMaximumSize(screenSize);
        screen.setMinimumSize(screenSize);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.add(screen);
        window.pack();
    }

    public void showWindow() {
        if(screen.getBufferStrategy() == null) {
            screen.createBufferStrategy(3);
        }
        window.setVisible(true);
    }

    public void show() {
        screen.getBufferStrategy().show();
        window.validate();
        getDrawingGraphics().dispose();
    }

    public Graphics getDrawingGraphics() {
        return screen.getBufferStrategy().getDrawGraphics();
    }

    public void clearScreen() {
        getDrawingGraphics().setColor(Color.BLACK);
        getDrawingGraphics().fillRect(0, 0, WIDTH, HEIGHT);
    }

}
