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
