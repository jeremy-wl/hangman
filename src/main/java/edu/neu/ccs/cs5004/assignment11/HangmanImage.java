package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jeremy on 4/8/17.
 */
class HangmanImage extends JPanel implements Observer {
    private static final Dimension IMAGE_SIZE = new Dimension(400, 504);
    private static final int OFFSET_FROM_TOP = 10;

    private GameState game;
    private HangmanImageLibrary imageLibrary;

    HangmanImage(GameState game) {
        this.game = game;

        this.imageLibrary = new HangmanImageLibrary();
        this.setPreferredSize(IMAGE_SIZE);
        this.game.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image hangman = imageLibrary.getHangmanImage(game.getGuessesLeft());
        g.drawImage(hangman, 0, OFFSET_FROM_TOP, this.getWidth(), this.getHeight(), this);
    }
}
