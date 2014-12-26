/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.vision.base;

import javax.swing.*;

/**
 *
 * @author FantasticNinjas
 */
public class Window extends JFrame{
    
    public Window(int x, int y) {
        this.setSize(x, y);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void update() {
        this.setVisible(true);
    }
    
}
