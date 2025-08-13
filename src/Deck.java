import utils.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.nio.file.Path;
import java.nio.file.Paths;


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
        int cardIdx = rand.nextInt(2, 14);
        int cardValue = this.cards.get(cardIdx).getValue();
        String cardSuit = this.cards.get(cardIdx).getSuit();
        String aux;
        Path path;

        switch (cardIdx) {
            case 11:
                aux = "ace_%s_white.png";
                aux = String.format(aux, cardSuit);
                path = Paths.get("assets","cards", aux);
                break;
            case 12:
                aux = "jack_%s_white.png";
                aux = String.format(aux, cardSuit);
                path = Paths.get("assets","cards", aux);
                break;
            case 13:
                path = Paths.get("assets","cards", "joker_white.png");
                break;
            case 14:
                aux = "king_%s_white.png";
                aux = String.format(aux, cardSuit);
                path = Paths.get("assets","cards", aux);
                break;
            case 15:
                aux = "queen_%s_white.png";
                aux = String.format(aux, cardSuit);
                path = Paths.get("assets","cards", aux);
                break;
            default:
                aux = "%d_%s_white.png";
                aux = String.format(aux, cardValue, cardSuit);
                path = Paths.get("assets","cards", aux);
        }
        this.cards.remove(cardIdx);
        return new Card(path.toAbsolutePath(), cardValue, cardSuit);
    }

    public Card blankCard() {
        Path path = Paths.get("assets","cards", "back_black_basic.png");
        path = path.toAbsolutePath();
        return new Card(path);
    }

    public void shuffle() {
        for (int i = 0; i < Constants.DECK_SIZE; i++) {
            Collections.swap(cards, i, rand.nextInt(Constants.DECK_SIZE));
        }
    }

}

