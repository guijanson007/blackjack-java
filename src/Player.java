import utils.Constants;
import utils.Frame;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int points;
    private int pos_x;
    private int pos_y;

    public Player() {
        pos_x = 0;
        pos_y = 0;
        points = 0;
    }

    public void deal(Card card, Frame frame) {
        if (!card.getImage().isValid()) {
            return;
        }
        this.cards.add(card);
        card.setBounds(pos_x,pos_y, Constants.CARD_WIDTH,Constants.CARD_HEIGHT);
        frame.add(card.getImage());
        frame.updateFrame();
        pos_x += Constants.CARD_WIDTH + 5;

        this.increasePoints(card.getValue());
        System.out.println("Card value: "  + card.getValue());
        System.out.println("Points: " + this.getPoints());
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }


    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void increasePoints(int points) {
        this.points += points;
    }

    public boolean isBust () {
        return this.getPoints() > 21;
    }
}
