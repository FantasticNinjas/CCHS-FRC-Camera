/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.vision.filters;

import robot.vision.base.Image;

/**
 *
 * @author FantasticNinjas
 */
public abstract class Filter extends Image {
    
    private Image imageData;
    
    /**
     * Apply the filter to a pixel of an image
     * @param x the x position of the pixel in the image
     * @param y the y position of the pixel in the image
     * @param RBG the color of the pixel as an RBG integer
     * @return the filtered pixel
     */
    protected abstract int filterPixel(int x, int y, int RBG);
    
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
                writableImage[pixelNumber] = this.filterPixel(x, y, this.getPixel(x, y, image, width, height));
            }
        }
        
        return writableImage;
    }
    
    /**
     * apply the filter to the image below the filter in the image flow.
     * @return the filtered image
     */
    protected int[] filterImage() {
        return filterImage(imageData.getRBG(), imageData.getWidth(), imageData.getHeight());
    }
    
    /**
     * get the color of an image's pixel
     * @param x the x position of the pixel
     * @param y the y position of the pixel
     * @param image the image as a linear array of RBG pixels
     * @param width the width of the image
     * @param height the height of the image
     * @return the color of the pixel located at (x, y)
     */
    protected int getPixel(int x, int y, int[] image, int width, int height) {
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

    protected int getPixel(int x, int y) {
        return getPixel(x, y, imageData.getRBG(), imageData.getWidth(), imageData.getHeight());
    }
    
    @Override
    public int[] getRBG() {
        return this.filterImage(imageData.getRBG(), imageData.getWidth(), imageData.getHeight());
    }
}
