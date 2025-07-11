import utils.ImagePanel;

import java.nio.file.Path;
import java.util.ArrayList;

public class Card {
    private int value;
    private final String suit;
    private final ImagePanel image = new ImagePanel();

    Card (Path filepath) {
        this.value = 0;
        this.suit = null;
        this.image.initialize(String.valueOf(filepath));
    }

    Card (Path filepath, int value, String suit) {
        this.image.initialize(String.valueOf(filepath));
        this.value = value;
        this.suit = suit;
    }

    Card (int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public void setBounds (int x, int y, int width, int height) {
        this.image.setBounds(x, y, width, height);
    }

    public ImagePanel getImage() {
        return this.image;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        if (this.value > 11) {
            return 10;
        }
        else {
            return this.value;
        }
    }

    public String getSuit() { return this.suit; }

}
