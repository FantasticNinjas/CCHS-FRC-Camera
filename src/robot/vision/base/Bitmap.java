/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.vision.base;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author FantasticNinjas
 */
public class Bitmap extends Image {
    private BufferedImage imageData;
      
    /**
     * create a bitmap object from a file.
     * @param imageFile the file from which to create a bitmap
     */
    public Bitmap(File imageFile) {
        try {
            imageData = ImageIO.read(imageFile);
        } catch (IOException ex) {
            Logger.getLogger(Bitmap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setWidth(imageData.getWidth());
        this.setHeight(imageData.getHeight());
    }
    
    @Override
    public BufferedImage getImage() {
        return imageData;
    }
    
}
