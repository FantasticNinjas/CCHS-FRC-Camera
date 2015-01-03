/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.vision.base;

import java.io.File;
import robot.vision.filters.Subtract;
import robot.vision.filters.Threshold;

/**
 *
 * @author FantasticNinjas
 */
public class Main {
    
    public static final int windowWidth = 800;
    public static final int windowHeight = 600;
    public static final String darkImagePath = "/Users/Ben1/NetBeansProjects/CCHS-FRC-Camera/Robot_Images/Dark.jpg";
    public static final String lightImagePath = "/Users/Ben1/NetBeansProjects/CCHS-FRC-Camera/Robot_Images/Light.jpg";
    
    public static void main(String[] args) {
        Window display = new Window(800, 600);
        
        Bitmap darkImage = new Bitmap(new File(Main.darkImagePath));
        Bitmap lightImage = new Bitmap(new File(Main.lightImagePath));
        
        Subtract combine = new Subtract(lightImage, darkImage);
        Threshold cutoff = new Threshold(combine, 1);
        ImageDrawer drawer = new ImageDrawer(cutoff);
        
        display.add(drawer);
        display.update();
    }
}
