import utils.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private final Random rand = new Random();

    Deck () {}

    public void buildDeck() {
        for (int i = 1; i <= Constants.DECK_SIZE; i++) {
            for (int j = 0; j < Constants.SUITS.length; j++) {
                    this.cards.add(new Card(i, Constants.SUITS[j]));
                }
            }
    }

    public Card pickCard() {
        int cardIdx = rand.nextInt(1, 15);
        int cardValue = this.cards.get(cardIdx).getValue();
        String cardSuit = this.cards.get(cardIdx).getSuit();
        String filepath;

        switch (cardIdx) {
            case 1:
            case 11:
                filepath = "/Users/guilhermejanson/projects/blackjack-java/assets/cards/ace_%s_white.png";
                filepath = String.format(filepath, cardSuit);
                break;
            case 12:
                filepath = "/Users/guilhermejanson/projects/blackjack-java/assets/cards/jack_%s_white.png";
                filepath = String.format(filepath, cardSuit);
                break;
            case 13:
                filepath = "/Users/guilhermejanson/projects/blackjack-java/assets/cards/joker_white.png";
                break;
            case 14:
                filepath = "/Users/guilhermejanson/projects/blackjack-java/assets/cards/king_%s_white.png";
                filepath = String.format(filepath, cardSuit);
                break;
            case 15:
                filepath = "/Users/guilhermejanson/projects/blackjack-java/assets/cards/queen_%s_white.png";
                filepath = String.format(filepath, cardSuit);
                break;
            default:
                filepath = "/Users/guilhermejanson/projects/blackjack-java/assets/cards/%d_%s_white.png";
                filepath = String.format(filepath, cardValue, cardSuit);
        }
        this.cards.remove(cardIdx);
        return new Card(filepath);
    }

    public Card blankCard() {
        String filepath = "/Users/guilhermejanson/projects/blackjack-java/assets/cards/back_black_basic.png";
        Card blankCard = new Card(filepath);
        return blankCard;
    }

    public void shuffle() {
        for (int i = 0; i < Constants.DECK_SIZE; i++) {
            Collections.swap(cards, i, rand.nextInt(Constants.DECK_SIZE));
        }
    }

}

