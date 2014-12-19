/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.vision.base;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author FantasticNinjas
 */
public class Image {
    
    private Color[] pixels;
    private int width;
    private int height;
    
    public Image(Color[] pixels, int width, int height) {
        this.pixels = pixels;
        this.width = width;
        this.height = height;
    }
    
    public Image(Color[] pixels, int width) {
        this.pixels = pixels;
        this.width = width;
        this.height = pixels.length / width;
    }
    
    /**
     *Creates and Image from a file. This uses built-in Java image IO.
     * @param imageFile The file from which to create the image
     * @return 
     */
    public static Image imageFromFile(File imageFile) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return imageFromBufferedImage(image);
    }
    
    public static Image imageFromBufferedImage(BufferedImage image) {
        int[] rbgPixels;
        rbgPixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
        
        Image returnValue = new Image(new Color[rbgPixels.length], image.getWidth(), image.getHeight());
        for (int i = 0; i < rbgPixels.length; i++) {
            returnValue.setPixelNumber(i, rbgPixels[i]);
        }
        
        return returnValue;
    }
    
    /**
     * @param x the pixel's x coordinate
     * @param y the pixel's y coordinate
     * @return  the pixel's color
     */
    public Color getPixel(int x, int y) {
        return pixels[y * width + x];
    }
    
    /**
     * Sets a specific pixel of an image to a color
     * @param x the pixel's x coordinate
     * @param y the pixel's y coordinate
     * @param color the pixel's new color as an RBG int
     */
    public void setPixel(int x, int y, Color color) {
        pixels[y * width + x] = color;
    }
    
    /**
     * Sets a specific pixel of an image to a color
     * @param x the pixel's x coordinate
     * @param y the pixel's y coordinate
     * @param color the pixel's new color as a java.awt.Color
     */
    public void setPixel(int x, int y, int color) {
        pixels[y * width + x] = new Color(color);
    }
    
    public void setPixelNumber(int number, int color) {
        pixels[number] = new Color(color);
    }
    
    /**
     * @return an image's pixels as an array of colors
     */
    public Color[] getPixels() {
        return pixels;
    }

    /**
     * @param pixels the pixels to set
     */
    public void setPixels(Color[] pixels) {
        this.pixels = pixels;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    
}
