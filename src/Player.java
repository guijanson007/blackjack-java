import utils.Constants;
import utils.Frame;
import utils.PointsLabel;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int points;
    private int card_pos_x;
    private int card_pos_y;
    private PointsLabel pointsLabel;

    public Player() {
        card_pos_x = 0;
        card_pos_y = 0;
        points = 0;
        pointsLabel = new PointsLabel();
    }

    public void deal(Card card, Frame frame) {
        if (!card.getImage().isValid()) {
            return;
        }
        this.cards.add(card);
        card.setBounds(card_pos_x,card_pos_y, Constants.CARD_WIDTH,Constants.CARD_HEIGHT);
        frame.add(card.getImage());

        card_pos_x += Constants.CARD_WIDTH + 5;
        this.increasePoints(card.getValue());

        this.pointsLabel.setPoints(this.getPoints());

        frame.updateFrame();
    }

    public void setCardPos_x(int pos_x) {
        this.card_pos_x = pos_x;
    }

    public void setCardPos_y(int pos_y) {
        this.card_pos_y = pos_y;
    }

    public void setPointsBounds(int pos_x, int pos_y, int width, int height) {
        this.pointsLabel.setBounds(pos_x, pos_y, width, height);
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
        return this.getPoints() >= 21;
    }

    public PointsLabel getPointsLabel() {
        return this.pointsLabel;
    }
}
