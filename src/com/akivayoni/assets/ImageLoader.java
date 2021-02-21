package com.akivayoni.assets;

import com.sun.javaws.exceptions.ErrorCodeResponseException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {

    public static BufferedImage loadImage(String name) {
        try {
            return ImageIO.read(ImageLoader.class.getResource("/" + name));
        } catch (IOException e) {
            throw new Error(e.getMessage());
        }
    }

}
