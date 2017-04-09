package edu.neu.ccs.cs5004.assignment11;

import java.awt.*;

/**
 * Created by Jeremy on 4/8/17.
 */
public class GuessesLeftLabel extends GameInfoLabel {
    public GuessesLeftLabel(GameState game) {
        setPreferredSize(new Dimension(400, 20));
        this.setFont(new Font("Monospaced", Font.BOLD, 15));

        int guesses = game.getGuessesLeft();
        String message = String.format("%s guesses left", guesses);
        this.setText(message);
    }

    @Override
    public void update(GameState game) {
        int guesses = game.getGuessesLeft();
        String message = String.format("%s guesses left", guesses);

        if (game.wins())        message = String.format("You won with %s", message);
        else if (game.lost())   message = String.format("You lost! (%s)", game.getSecretWord());

        this.setText(message);
    }
}
