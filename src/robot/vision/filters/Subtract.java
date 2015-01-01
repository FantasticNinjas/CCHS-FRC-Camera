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
public class Subtract extends Combine {
    
    public Subtract(Image imageData, Image modifier) {
        super(imageData, modifier);
    }

    @Override
    protected Color filterPixel(int x, int y, int mainRBG, int modifierRBG) {
        int mainR = mainRBG & 0xFF;
        int mainB = (mainRBG >> 8) & 0xFF;
        int mainG = (mainRBG >> 16) & 0xFF;
        
        //The problem here is that getPixel is extremely slow!!!!!!
        int modifierR = modifierRBG & 0xFF;
        int modifierB = (modifierRBG >> 8) & 0xFF;
        int modifierG = (modifierRBG >> 16) & 0xFF;
        
        if (modifierR > mainR) {
            mainR = 0;
        } else {
            mainR -= modifierR;
        }
        
        if (modifierB > mainB) {
            mainB = 0;
        } else {
           mainB -= modifierB; 
        }
        
        if (modifierG > mainG) {
            mainG = 0;
        } else {
            mainG -= modifierG;
        }
        
        return new Color(mainR, mainB, mainG);
    }
}
