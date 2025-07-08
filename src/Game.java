import utils.Frame;

public class Game {
    private Deck deck = new Deck();
    private Player player = new Player();
    private Player dealer = new Player();
    private Frame frame = new Frame();

    Game(Deck deck, Player player, Player dealer, Frame frame) {
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
        this.frame = frame;
    }

    public void start() {
        this.deck.buildDeck();
        this.deck.shuffle();
        this.dealer.deal(deck.pickCard(), this.frame);
        this.player.deal(deck.pickCard(), this.frame);
    }


}
