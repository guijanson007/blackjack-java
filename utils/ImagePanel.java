package utils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;
    boolean isValid;

    public ImagePanel() {

    }

    public void initialize(String filepath) {
        try {
            image = ImageIO.read(new File(filepath));
            this.isValid = true;
        } catch (IOException ex) {
            System.out.println("Error reading image file: " + filepath);
            this.isValid = false;
        }
    }
    @Override
    public boolean isValid() {
        return this.isValid;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
    }

}