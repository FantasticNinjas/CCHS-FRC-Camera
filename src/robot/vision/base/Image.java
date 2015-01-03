/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.vision.base;

import java.awt.image.BufferedImage;

/**
 *
 * @author FantasticNinjas
 */
public abstract class Image{
    /**
     * The width of the image
     */
    private int width;
    /**
     * The height of the image
     */
    private int height;
    
    /**
     * 
     * @return The image's data represented as a BufferedImage
     */
    public abstract BufferedImage getImage();
    
    /**
     * 
     * @return The image's data represented as a linear array of RBG integers
     */
    public int[] getRBG() {
        BufferedImage imageData = this.getImage();
        return imageData.getRGB(0, 0, imageData.getWidth(), imageData.getHeight(), null, 0, imageData.getWidth());
    }
    
        
    /**
     * get the color of an image's pixel
     * @param x the x position of the pixel
     * @param y the y position of the pixel
     * @param image the image as a linear array of RBG pixels
     * @param width the width of the image
     * @param height the height of the image
     * @return the color of the pixel located at (x, y) as an RBG integer
     */
    public int getPixel(int x, int y, int[] image, int width, int height) {
        int trueX = x;
        int trueY = y;
        
        //Make sure trueX is in bounds
        if (trueX < 0) {
            trueX = 0;
        }
        if (trueX >= width) {
            trueX = width - 1;
        }
        
        //Make sure trueY is in bonds
        if (trueY < 0) {
            trueY = 0;
        }
        if (trueY >= height) {
            trueY = height - 1;
        }
        
        return image[trueY * width + trueX];
    }
    
    /**
     * get the color of the image below this one in the stack
     * @param x the x position of the pixel
     * @param y the y position of the pixel
     * @return the color of the pixel located at (x, y) as an RBG integer
     */
    public abstract int getPixel(int x, int y);

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
