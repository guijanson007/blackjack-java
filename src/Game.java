import utils.Frame;

public class Game {
    private Deck deck = new Deck();
    private Player player = new Player();
    private Player dealer = new Player();
    private Frame frame = new Frame();

    Game(Deck deck, Player player, Player dealer, Frame frame) {
        this.deck = deck;

        //player frame positions
        this.player = player;
        player.setPos_x(10);
        player.setPos_y(10);

        //dealer frame positions
        this.dealer = dealer;
        dealer.setPos_x(10);
        dealer.setPos_y(250);

        this.frame = frame;
    }

    public void start() {
        this.deck.buildDeck();
        this.deck.shuffle();
        this.dealer.deal(deck.blankCard(), this.frame);
        this.dealer.deal(deck.pickCard(), this.frame);
        this.player.deal(deck.pickCard(), this.frame);
    }


}
