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
public class Threshold extends Filter {
    private final int thresholdValue;
    
    public Threshold(Image imageData, int thresholdValue) {
        super(imageData);
        this.thresholdValue = thresholdValue;
    }

    @Override
    protected Color filterPixel(int x, int y, Color RBG) {
        int mainR = RBG.getRed();
        int mainB = RBG.getBlue();
        int mainG = RBG.getGreen();
        
        if ((mainR + mainB + mainG) / 3 < thresholdValue) {
            return Color.BLACK;
        }
        return Color.WHITE;
    }
    
}
