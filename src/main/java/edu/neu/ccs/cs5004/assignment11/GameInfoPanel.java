package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jeremy on 4/8/17.
 */
public class GameInfoPanel extends JPanel implements Observer {
    private GameState game;
    private GuessedLetterLabel guessedLetterLabel;
    private GuessesLeftLabel guessesLeftLabel;
//    private JLabel secretLetters;

    GameInfoPanel(GameState game,
                  GuessedLetterLabel letterLabel, GuessesLeftLabel guessesLabel) {
//        this.secretLetters = secretLetters;
        this.guessedLetterLabel = letterLabel;
        this.guessesLeftLabel = guessesLabel;
        this.game = game;

        this.add(guessesLeftLabel);
        this.add(guessedLetterLabel);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        game.addObserver(this);
    }

    @Override
    public void update(Observable obj, Object arg) {
        this.guessedLetterLabel.update(game);
        this.guessesLeftLabel.update(game);
    }
}
