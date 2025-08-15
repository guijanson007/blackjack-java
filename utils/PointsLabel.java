package utils;

import javax.swing.*;

public class PointsLabel extends JLabel {
    private final JLabel pointsLabel;

    public PointsLabel(int points) {
        this.pointsLabel = new JLabel(Integer.toString(points));
    }

    public PointsLabel() {
        this.pointsLabel = new JLabel();
    }

    public void setPoints(int points) {
        this.pointsLabel.setText("Points: " + Integer.toString(points));
    }
}
