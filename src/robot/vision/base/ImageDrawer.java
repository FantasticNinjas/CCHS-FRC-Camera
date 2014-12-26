/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.vision.base;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author FantasticNinjas
 */
public class ImageDrawer extends JComponent{

    private final Image imageData;
    
    public ImageDrawer(Image imageData) {
        this.imageData = imageData;
    }
    
    public BufferedImage getImage() {
        return imageData.getImage();
    }
    
    //Graphics Methods
    @Override
    public void paint(Graphics g) {
        g.drawImage(this.getImage(), 0, 0, null);
    }
}
