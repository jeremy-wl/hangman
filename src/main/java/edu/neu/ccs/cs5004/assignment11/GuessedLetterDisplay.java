package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jeremy on 4/8/17.
 */
public class GuessedLetterDisplay extends JPanel implements Observer {
    private GameState game;
    private JLabel guessWordLabel;
    private static final String GUESSED_COLOR = "blue";
    private static final String UNGUESSED_COLOR = "gray";

    public GuessedLetterDisplay(GameState game) {
        super();
        this.game = game;
        setPreferredSize( new Dimension( 300, 100 ) );
        guessWordLabel = new JLabel(htmlFlavoredText(game.getGuessedWordMap()));
        add(guessWordLabel);
        game.addObserver(this);
        setBackground(Color.white);
    }

    @Override
    public void update(Observable obj, Object arg) {
        guessWordLabel = new JLabel(htmlFlavoredText(game.getGuessedWordMap()));
        remove(0);              // remove old label
        add(guessWordLabel);    // add new label
        revalidate();           // repaint with the new label
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
