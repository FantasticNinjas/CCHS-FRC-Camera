/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.vision.base;

/**
 *
 * @author FantasticNinjas
 */
public class Measure {
    
    public static int getSectionTop(Image toMeasure, int sectionColor) {
        final int width = toMeasure.getWidth();
        final int height = toMeasure.getHeight();
        final int[] imageArray = toMeasure.getRBG();
        
        //Going forward, the first pixel in the array that is selectionColor will be the top one
        for (int y = 0; y < height; y++) {
           for (int x = 0; x < width; x++) {
               if (toMeasure.getPixel(x, y, imageArray, width, height) == sectionColor) {
                   return y;
               }
           }
        }
        return -1;
    }
    
    public static int getSectionBottom(Image toMeasure, int sectionColor) {
        final int width = toMeasure.getWidth();
        final int height = toMeasure.getHeight();
        final int[] imageArray = toMeasure.getRBG();
        
        //Going backward, the first pixel in the array that is selectionColor will be the bottom one
        for (int y = height - 1; y >= 0; y--) {
           for (int x = 0; x < width; x++) {
               if (toMeasure.getPixel(x, y, imageArray, width, height) == sectionColor) {
                   return y;
               }
           }
        }
        return -1;
    }
    
}
