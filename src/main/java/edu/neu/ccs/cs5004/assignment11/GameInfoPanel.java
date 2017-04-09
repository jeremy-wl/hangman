package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jeremy on 4/8/17.
 */
public class GameInfoPanel extends JPanel implements Observer {
    private GameState game;
    private List<GameInfoLabel> labels;

    GameInfoPanel(GameState game, GameInfoLabel secretWordLabel,
                  GameInfoLabel guessesLabel, GameInfoLabel letterLabel) {
        this.game = game;

        labels = new ArrayList<>();
        labels.add(secretWordLabel);
        labels.add(guessesLabel);
        labels.add(letterLabel);

        for (JLabel label : labels) {                     // Seems that the first alignment only
            this.add(label);                              // works on plain text string, while the
            label.setAlignmentX(JLabel.CENTER_ALIGNMENT); // second one works only for html based string.
            label.setHorizontalAlignment(JLabel.CENTER);  // Don't know if there's better way to do this
        }                                                 // except wrapping all of those in html

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        game.addObserver(this);
    }

    @Override
    public void update(Observable obj, Object arg) {
        for (GameInfoLabel label : labels) {
            label.update(game);
        }
    }
}
