package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jeremy on 4/8/17.
 */
public class GuessesLeftLabel extends JLabel {
    public GuessesLeftLabel(GameState game) {
        super();
        setPreferredSize(new Dimension(300, 100));

        int guesses = game.getGuessesLeft();
        this.setText(guesses + " " + "guesses left");
        setBackground(Color.white);
    }

    public void update(GameState game) {
        int guesses = game.getGuessesLeft();
        this.setText(guesses + " " + "guesses left");
    }
}
