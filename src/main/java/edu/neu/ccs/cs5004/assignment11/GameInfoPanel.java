package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jeremy on 4/8/17.
 */
public class GameInfoPanel extends JPanel implements Observer {
    private GameState game;
    private SecretWordLabel secretWordLabel;
    private GuessedLettersLabel guessedLettersLabel;
    private GuessesLeftLabel guessesLeftLabel;

    GameInfoPanel(GameState game, SecretWordLabel secretWordLabel,
                  GuessesLeftLabel guessesLabel, GuessedLettersLabel letterLabel) {
        this.secretWordLabel = secretWordLabel;
        this.guessesLeftLabel = guessesLabel;
        this.guessedLettersLabel = letterLabel;
        this.game = game;

        this.add(secretWordLabel);
        this.add(guessesLeftLabel);
        this.add(guessedLettersLabel);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        game.addObserver(this);
    }

    @Override
    public void update(Observable obj, Object arg) {
        this.secretWordLabel.update(game);
        this.guessesLeftLabel.update(game);
        this.guessedLettersLabel.update(game);
    }
}
