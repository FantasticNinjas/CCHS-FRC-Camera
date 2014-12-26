/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.vision.base;

import java.io.File;

/**
 *
 * @author FantasticNinjas
 */
public class Main {
    
    public static final int windowWidth = 800;
    public static final int windowHeight = 600;
    public static final String frogPath = "/Users/Ben1/Desktop/Frog.jpg";
    
    public static void main(String[] args) {
        Window display = new Window(800, 600);
        
        Bitmap frog = new Bitmap(new File(Main.frogPath));
        ImageDrawer frogDraw = new ImageDrawer(frog);
        
        display.add(frogDraw);
        display.update();
    }
}
