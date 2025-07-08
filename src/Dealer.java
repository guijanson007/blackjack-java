import utils.Constants;
import utils.Frame;

public class Dealer extends Player{
    private int pos_x = 10;
    private int pos_y = 10;

    public Dealer() {
        super();
    }
    
    //deals blank card to be flipped-
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
}
