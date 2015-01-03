/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.vision.filters;

import java.awt.Color;
import java.awt.image.BufferedImage;
import robot.vision.base.Image;

/**
 *
 * @author FantasticNinjas
 */
public abstract class Filter extends Image {
    
    protected Image imageData;
    
    protected Filter(Image imageData) {
        this.imageData = imageData;
        this.setWidth(imageData.getWidth());
        this.setHeight(imageData.getHeight());
    }
    
    /**
     * Apply the filter to a pixel of an image
     * @param x the x position of the pixel in the image
     * @param y the y position of the pixel in the image
     * @param RBG the color of the pixel as an RBG integer
     * @return the filtered pixel
     */
    protected abstract Color filterPixel(int x, int y, Color RBG);
    
    /**
     * apply the filter to an arbitrary image
     * @param image the image to filter as a linear array of RBG pixels
     * @param width the width of the image
     * @param height the height of the image
     * @return the filtered image as a linear array of RBG pixels
     */
    protected int[] filterImage(int[] image, int width, int height) {
        int[] writableImage = image;
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixelNumber = y * width + x;
                Color pixelColor = new Color(this.getPixel(x, y, image, width, height));
                writableImage[pixelNumber] = this.filterPixel(x, y, pixelColor).getRGB();
            }
        }
        
        return writableImage;
    }
    
    /**
     * apply the filter to the image below the filter in the image flow.
     * @return the filtered image
     */
    protected int[] filterImage() {
        return filterImage(imageData.getRBG(), this.getWidth(), this.getHeight());
    }
    
    @Override
    public int[] getRBG() {
        return this.filterImage();
    }
    
    @Override
    public BufferedImage getImage() {
        BufferedImage toReturn = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        toReturn.setRGB(0, 0, this.getWidth(), getHeight(), this.getRBG(), 0, this.getWidth());
        return toReturn;
    }
    
    @Override
    public int getPixel(int x, int y) {
        return this.getPixel(x, y, imageData.getRBG(), this.getWidth(), this.getHeight());
    }
}
