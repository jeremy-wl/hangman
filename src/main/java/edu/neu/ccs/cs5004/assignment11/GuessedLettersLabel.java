package edu.neu.ccs.cs5004.assignment11;

import java.awt.*;
import java.util.Map;

/**
 * Created by Jeremy on 4/8/17.
 */
public class GuessedLettersLabel extends GameInfoLabel {
    private static final String GUESSED_COLOR = "blue";
    private static final String UNGUESSED_COLOR = "gray";

    public GuessedLettersLabel(GameState game) {
        setPreferredSize(new Dimension(500, 100));
        this.setText(htmlFlavoredText(game.getGuessedLetters()));
        setBackground(Color.white);
    }

    @Override
    public void update(GameState game) {
        this.setText(htmlFlavoredText(game.getGuessedLetters()));
    }

    /***************************** Private Methods *****************************/

    private StringBuilder wrapColoredTextWithHTMLTags(String color, Character text) {
        StringBuilder res = new StringBuilder();
        res.append("<font color=").append(color).append(">");
        res.append(text);
        res.append("</font>");
        return res;
    }

    private String htmlFlavoredText(Map<Character, Boolean> guessedWord) {
        StringBuilder text = new StringBuilder();
        text.append("<html>");
        for (char c : GameState.ALL_POSSIBLE_LETTERS.toCharArray()) {
            if (text.length() != 0) text.append(" ");
            if (!guessedWord.get(c)) {
                text.append(wrapColoredTextWithHTMLTags(UNGUESSED_COLOR, c));
            } else {
                text.append(wrapColoredTextWithHTMLTags(GUESSED_COLOR, c));
            }
        }
        text.append("</html>");
        return text.toString();
    }
}
