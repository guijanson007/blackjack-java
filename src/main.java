import utils.Constants;
import utils.Frame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Main {
    public static void main (String[] args) {
        Frame startFrame = new Frame();
        Frame mainFrame = new Frame();
        Player player = new Player();
        Player dealer = new Player();
        Deck deck = new Deck();
        Game game = new Game(deck, player, dealer, mainFrame);

        JButton startButton = new JButton("Start");
        startButton.setBounds(350, 450, 100, 50);
        ActionListener startButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFrame.showFrame(false);
                mainFrame.showFrame(true);
            }
        };
        startButton.addActionListener(startButtonListener);

        JLabel startLabel = new JLabel("Welcome to blackjack");
        startLabel.setBounds(Constants.CENTER_HOR - 80, Constants.CENTER_VERT - 50, 200, 50);

        startFrame.add(startButton);
        startFrame.add(startLabel);
        startFrame.showFrame(true);

        game.start();

        JButton dealButton = new JButton("Deal");
        dealButton.setBounds(350, 450, 100, 50);

        ActionListener dealButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        dealButton.addActionListener(dealButtonListener);
        mainFrame.add(dealButton);

    }
}