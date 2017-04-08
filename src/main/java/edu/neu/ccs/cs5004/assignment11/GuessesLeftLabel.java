package edu.neu.ccs.cs5004.assignment11;

import java.awt.*;

/**
 * Created by Jeremy on 4/8/17.
 */
public class GuessesLeftLabel extends GameInfoLabel {
    public GuessesLeftLabel(GameState game) {
        super();
        setPreferredSize(new Dimension(300, 100));

        int guesses = game.getGuessesLeft();
        this.setText(guesses + " " + "guesses left");
        setBackground(Color.white);
    }

    @Override
    public void update(GameState game) {
        int guesses = game.getGuessesLeft();
        this.setText(guesses + " " + "guesses left");
    }
}
