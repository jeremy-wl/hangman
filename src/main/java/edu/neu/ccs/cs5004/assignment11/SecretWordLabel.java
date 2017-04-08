package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * Created by Jeremy on 4/8/17.
 */
class SecretWordLabel extends JLabel {

    public SecretWordLabel(GameState game) {
        super();
        setPreferredSize(new Dimension(300, 100));
        setBackground(Color.white);

        StringBuilder secretString = new StringBuilder();
        for (int i = 0; i < game.getGuessesLeft(); i++) {
            secretString.append('?');
        }

        this.setText(secretString.toString());
    }

    public void update(GameState game) {
        StringBuilder secretString = new StringBuilder();

        for (char wordLetter : game.getSecretWord().toCharArray()) {
            char character = game.getGuessedLetters().get(wordLetter) ? wordLetter : '?';
            secretString.append(character);
        }

        this.setText(secretString.toString());
    }
}
