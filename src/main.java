import utils.Constants;
import utils.Frame;
import utils.PointsLabel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


class Main {
    public static void main (String[] args) {
        Frame startFrame = new Frame();
        Frame mainFrame = new Frame();
        Player player = new Player();
        Player dealer = new Player();
        PointsLabel playerPointsLabel = new PointsLabel();
        PointsLabel dealerPointsLabel = new PointsLabel();
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

        game.start(playerPointsLabel, dealerPointsLabel);


        JButton dealButton = new JButton("Hit");
        dealButton.setBounds(250, 450, 100, 50);

        ActionListener dealButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.hit(playerPointsLabel, dealerPointsLabel);
            }
        };
        dealButton.addActionListener(dealButtonListener);



        JButton standButton = new JButton("Stand");
        standButton.setBounds(400, 450, 100, 50);

        ActionListener standButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.stand(playerPointsLabel, dealerPointsLabel);
            }
        };
        standButton.addActionListener(standButtonListener);

        playerPointsLabel.setBounds(300, 10, 200, 200);
        dealerPointsLabel.setBounds(300, 250, 200, 200);

        mainFrame.add(playerPointsLabel);
        mainFrame.add(dealerPointsLabel);
        mainFrame.add(dealButton);
        mainFrame.add(standButton);



    }
}