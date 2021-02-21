package com.akivayoni.display;

import com.akivayoni.assets.Assets;

import java.awt.*;

public class BoardRenderer {

    private static final int TILE_MAX_SIZE = 80;
    private static final int STARTING_X = Window.WIDTH / 10;
    private static final int STARTING_Y = Window.HEIGHT / 10;

    public static void render(int[][] board, Graphics graphics) {
        assert board != null && board[0] != null;
        int height = board.length;
        int width = board[0].length;
        int tileSize = getTileSize(height, width);
        graphics.setColor(Color.white);
        drawGrid(width,
                height,
                tileSize,
                graphics);
        drawEntities(board,
                tileSize,
                graphics);
    }

    private static int getTileSize(int height, int width) {
        int tileHeight = (Window.HEIGHT - Window.HEIGHT / 5) / height;
        int tileWidth = (Window.WIDTH - Window.WIDTH / 5) / width;
        int tileSize = Math.min(tileHeight, tileWidth);
        return Math.min(tileSize, TILE_MAX_SIZE);
    }

    private static void drawEntities(int[][] board, int tileSize, Graphics graphics) {
        int x;
        int y;
        int rotation;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(!emptyTile(board[i][j])) {
                    x = STARTING_X + j * tileSize;
                    y = STARTING_Y + i * tileSize;
                    // TODO: 21/02/2021 set rotation
                    rotation = getRotation(board[i][j]);
                    if(rotation == 4) {
                        System.out.println(rotation);
                    }
                    graphics.drawImage(Assets.getInstance().getImage(board[i][j], rotation),
                            x + tileSize / 20,
                            y + tileSize / 20,
                            (tileSize / 10) * 9 ,
                            (tileSize / 10) * 9,
                            null);
                }
            }
        }
    }

    private static int getRotation(int value) {
        if(value >= 4 || value < 0) {
            return 0;
        }
        return value * 90;
    }

    private static boolean emptyTile(int tileValue) {
        return tileValue == 0;
    }

    private static void drawGrid(int width, int height, int tileSize, Graphics graphics) {
        int tempX;
        for (int i = 0; i <= width; i++) {
            tempX = STARTING_X + (i * tileSize);
            graphics.drawLine(tempX, STARTING_Y, tempX, Window.HEIGHT - STARTING_Y - tileSize);
        }
        int tempY;
        for (int i = 0; i <= height; i++) {
            tempY = STARTING_Y + (i * tileSize);
            graphics.drawLine(STARTING_X, tempY, Window.WIDTH - STARTING_X - STARTING_X / 7, tempY);
        }
    }

}
