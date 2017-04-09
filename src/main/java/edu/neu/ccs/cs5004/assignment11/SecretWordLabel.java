package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jeremy on 4/8/17.
 */
class SecretWordLabel extends GameInfoLabel {

    public SecretWordLabel(GameState game) {
        setPreferredSize(new Dimension(500, 100));

        StringBuilder secretString = new StringBuilder();
        for (int i = 0; i < game.getSecretWord().length(); i++) {
            secretString.append('?');
        }

        this.setText(secretString.toString());
    }

    @Override
    public void update(GameState game) {
        StringBuilder secretString = new StringBuilder();

        for (char wordLetter : game.getSecretWord().toCharArray()) {
            char character = game.getGuessedLetters().get(wordLetter) ? wordLetter : '?';
            secretString.append(character);
        }

        this.setText(secretString.toString());
    }
}
