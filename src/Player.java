import utils.Constants;
import utils.Frame;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int points;
    private int pos_x = 10;
    private int pos_y = 10;

    public Player() {}

    public void deal(Card card, Frame frame) {
        if (!card.getImage().isValid()) {
            return;
        }
        this.cards.add(card);
        card.setBounds(pos_x,pos_y, Constants.CARD_WIDTH,Constants.CARD_HEIGHT);
        frame.add(card.getImage());
        frame.updateFrame();
        pos_x += Constants.CARD_WIDTH + 5;
    }

}
