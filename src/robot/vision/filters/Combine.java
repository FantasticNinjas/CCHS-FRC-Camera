/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.vision.filters;

import java.awt.Color;
import robot.vision.base.Image;

/**
 *
 * @author FantasticNinjas
 */
public abstract class Combine extends Filter {
    protected final Image modifier;
    
    public Combine(Image imageData, Image modifier) {
        super(imageData);
        this.modifier = modifier;
    }
    
    @Override
    protected int[] filterImage(int[] image, int width, int height) {
        int[] writableImage = image;
        final int[] modifierBuffer = modifier.getRBG();
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixelNumber = y * width + x;
                int pixelColor = this.getPixel(x, y, image, width, height);
                int modifierColor = this.getPixel(x, y, modifierBuffer, width, height);
                writableImage[pixelNumber] = this.filterPixel(x, y, pixelColor, modifierColor).getRGB();
            }
        }
        
        return writableImage;
    }
    
    protected abstract Color filterPixel(int x, int y, int mainRBG, int modifierRBG);
    
    @Override
    protected Color filterPixel(int x, int y, Color RBG) {
        throw new UnsupportedOperationException("Wrong filterPixel method. Use filterPixel(x, y, mainRBG, modifierRBG) instead");
    }
}
