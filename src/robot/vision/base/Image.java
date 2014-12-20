/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.vision.base;

import java.awt.image.BufferedImage;

/**
 *
 * @author FantasticNinjas
 */
public abstract class Image{
    public abstract BufferedImage getImage();
    
    public int[] getRBG() {
        BufferedImage imageData = this.getImage();
        return imageData.getRGB(0, 0, imageData.getWidth(), imageData.getHeight(), null, 0, imageData.getWidth());
    }
}
