import utils.Frame;

import static utils.Constants.*;

public class Game {
    private Deck deck = new Deck();
    private Player player = new Player();
    private Player dealer = new Player();
    private Frame frame = new Frame();

    Game(Deck deck, Player player, Player dealer, Frame frame) {
        this.deck = deck;

        //player initial conditions
        this.player = player;
        player.setCardPos_x(10);
        player.setCardPos_y(10);
        player.setPointsBounds(400, 10, 200, 200);
        player.setPoints(0);

        //dealer initial conditions
        this.dealer = dealer;
        dealer.setCardPos_x(10);
        dealer.setCardPos_y(250);
        dealer.setPointsBounds(400, 250, 200, 200);
        dealer.setPoints(0);

        this.frame = frame;
    }

    public void start() {
        this.deck.buildDeck();
        this.frame.add(this.player.getPointsLabel());
        this.frame.add(this.dealer.getPointsLabel());
        this.player.deal(deck.pickCard(), this.frame);
        this.dealer.deal(deck.pickCard(), this.frame);
    }

    public void hit() {
        if (this.player.isBust()) {
            return;
        }
        else {
            this.player.deal(deck.pickCard(), this.frame);
        }
    }

    public void stand() {
        while (!this.dealer.isBust()) {

            this.dealer.deal(deck.pickCard(), this.frame);

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore the interrupted status
                System.out.println("Thread was interrupted while sleeping: " + e.getMessage());
            }
        }
    }

    public int eval (Player player, Player dealer) {
        if (player.getPoints() > 21) {
            return DEALER_WINS;
        }

        if (dealer.getPoints() > 21) {
            return PLAYER_WINS;
        }

        if (player.getPoints() > dealer.getPoints()) {
            return PLAYER_WINS;
        }

        if (dealer.getPoints() > player.getPoints()) {
            return DEALER_WINS;
        }
        return ERROR_EVALUATION;
    }

    public int end() {
        return eval(this.player, this.dealer);
    }

}
