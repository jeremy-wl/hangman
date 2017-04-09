package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jeremy on 4/8/17.
 */
class HangmanImage extends JLabel implements Observer {
    private static final int IMG_WIDTH  = 400;
    private static final int IMG_HEIGHT = 504;

    private GameState game;
    private HangmanImageLibrary imageLibrary;

    HangmanImage(GameState game) {
        this.game = game;
        this.imageLibrary = new HangmanImageLibrary();

        this.setIcon(getScaledImageIcon(IMG_WIDTH, IMG_HEIGHT, GameState.MAX_GUESSES_ALLOWED));
        this.game.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setIcon(getScaledImageIcon(IMG_WIDTH, IMG_HEIGHT, game.getGuessesLeft()));
    }

    private ImageIcon getScaledImageIcon(int width, int height, int guessesLeft) {
        ImageIcon imgIcon = imageLibrary.getHangmanImage(guessesLeft);
        Image image = imgIcon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
}
