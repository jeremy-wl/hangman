package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jeremy on 4/8/17.
 */
public class GameInfoPanel extends JPanel implements Observer {
    private GameState game;
    private GuessedLetterLabel guessedLetters;
//    private JLabel secretLetters;
//    private JLabel numOfGuesses;

    /**
     * Create a new buffered JPanel with the specified layout manager
     *
     * @param layout the LayoutManager to use
     */
    public GameInfoPanel(LayoutManager layout, GameState game,
                         GuessedLetterLabel guessedLetters) {
        super(layout);
//        this.secretLetters = secretLetters;
//        this.numOfGuesses = numOfGuesses;
        this.guessedLetters = guessedLetters;
        this.game = game;
        this.add(guessedLetters);
        game.addObserver(this);
    }

    @Override
    public void update(Observable obj, Object arg) {
        this.guessedLetters.update(game);
    }
}
