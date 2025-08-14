import utils.Constants;

import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Deck {
    private final Random rand = new Random();
    private Map<Integer, ArrayList<String>> cards  = new HashMap<Integer, ArrayList<String>>();

    Deck () {}

    public void buildDeck() {
        for (int i = Constants.LOWEST_VALUE; i <= Constants.HIGHEST_VALUE; i++) {
            this.cards.put(i,new ArrayList<>(Constants.SUITS));
        }
    }

    public Card pickCard() {
        int cardValue = rand.nextInt(Constants.LOWEST_VALUE, (Constants.HIGHEST_VALUE + 1));

        int randomSuitIdx = rand.nextInt(0, Constants.SUITS.size());
        String cardSuit = this.cards.get(cardValue).get(randomSuitIdx);

        String aux;
        Path path;
        switch (cardValue) {
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
        removeValue(this.cards, cardValue, cardSuit);
        return new Card(path.toAbsolutePath(), cardValue, cardSuit);
    }

    public Card blankCard() {
        Path path = Paths.get("assets","cards", "back_black_basic.png");
        path = path.toAbsolutePath();
        return new Card(path);
    }

    // Helper method to remove a specific value from the list associated with a key
    private static <K, V> void removeValue(Map<K, ArrayList<V>> map, K key, V value) {
        // Get the list for the key, or null if the key doesn't exist
        ArrayList<V> values = map.get(key);
        if (values == null) {
            return; // Key doesn't exist
        }

        // Remove the specific value from the list
        boolean removed = values.remove(value);
        if (removed) {
            // If the list is now empty, remove the key from the map
            if (values.isEmpty()) {
                map.remove(key);
            } else {
                // Update the map with the modified list
                map.put(key, values);
            }
        }
    }

    /*public void shuffle() {
        for (int i = 0; i < Constants.DECK_SIZE; i++) {
            Collections.swap(cards, i, rand.nextInt(Constants.DECK_SIZE));
        }
    }
*/
}

