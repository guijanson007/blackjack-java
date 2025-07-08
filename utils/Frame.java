package utils;

import java.awt.*;

import javax.swing.JFrame;

public class Frame  {
    private final JFrame frame = new JFrame();
    
    public Frame() {
        initialize();
    }

    private void initialize() {
        frame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        frame.setTitle("Blackjack game:");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
    public void add(Component comp) {
        frame.add(comp);
    }
    public void showFrame(boolean bool) {
        frame.setVisible(bool);
    }
    public void updateFrame() {
        frame.repaint();
    }

}


