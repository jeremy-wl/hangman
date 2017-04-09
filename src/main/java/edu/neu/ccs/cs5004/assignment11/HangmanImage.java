package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jeremy on 4/8/17.
 */
class HangmanImage extends JPanel implements Observer {

    private GameState game;
    private HangmanImageLibrary imageLibrary;

    HangmanImage(GameState game) {
        this.game = game;

        this.imageLibrary = new HangmanImageLibrary();
        this.setPreferredSize(new Dimension(400, 504));  // TODO: fix all magic numbers
        this.game.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageLibrary.getHangmanImage(game.getGuessesLeft()).getImage(),
                0, 0, this.getWidth(), this.getHeight(), this);  // TODO: refactor this
    }
}
