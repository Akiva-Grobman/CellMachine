package com.akivayoni.assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import static com.akivayoni.assets.ImageLoader.loadImage;

public class Assets {

    public static final int NINETY_DEGREES = 90;
    public static final int DUPLICATOR_ID = 0;
    public static final int EMPTY_ID = 1;
    public static final int ENEMY_ID = 2;
    public static final int MOVER_ID = 3;
    public static final int PUSHED_ID = 5;
    public static final int ROTATOR_ID = 4;
    public static final int SLIDER_ID = 6;
    private static Assets instance = null;

    private final HashMap<Integer, BufferedImage[]> imageMap;

    private Assets() {
        imageMap = new HashMap<>();
        imageMap.put(DUPLICATOR_ID, getAllStates("duplicator"));
        imageMap.put(EMPTY_ID, getAllStates("empty"));
        imageMap.put(ENEMY_ID, getAllStates("enemy"));
        imageMap.put(MOVER_ID, getAllStates("mover"));
        imageMap.put(PUSHED_ID, getAllStates("pushed"));
        imageMap.put(ROTATOR_ID, getAllStates("rotator"));
        imageMap.put(SLIDER_ID, getAllStates("slider"));
    }

    private BufferedImage[] getAllStates(String name) {
        return getRotations(loadImage("cells/" + name + ".png"));
    }

    private BufferedImage[] getRotations(BufferedImage loadImage) {
        BufferedImage[] images = new BufferedImage[4];
        for (int i = 0; i < images.length; i++) {
            final int height = loadImage.getHeight();
            final int width = loadImage.getWidth();
            BufferedImage dest = new BufferedImage(width, height, loadImage.getType());
            Graphics2D graphics2D = dest.createGraphics();
            graphics2D.translate((height - width) / 2, (height - width) / 2);
            graphics2D.rotate(Math.toRadians(i * 90), width / 2f, height / 2f);
            graphics2D.drawRenderedImage(loadImage, null);
            images[i] = dest;
        }
        return images;
    }

    public static Assets getInstance() {
        if(instance == null) {
            instance = new Assets();
        }
        return instance;
    }

    public BufferedImage getImage(int imageId, int rotation) {
        if(notALegalRotation(rotation)) {
            throw new Error(rotation + " isn't a legal rotation");
        }
        if(rotation / NINETY_DEGREES > 3) {
            System.out.println(rotation);
        }
        return imageMap.get(imageId)[rotation / NINETY_DEGREES];
    }

    private boolean notALegalRotation(int rotation) {
        for (int i = 0; i < 270; i+=90) {
            if(rotation % 90 == i) {
                return false;
            }
        }
        return true;
    }

}
