package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jeremy on 4/8/17.
 */
class PanelGameInfo extends JPanel implements Observer {
    private GameState game;
    private List<LabelGameInfo> labels;

    PanelGameInfo(GameState game, LabelGameInfo secretWordLabel,
                  LabelGameInfo guessesLabel, LabelGameInfo letterLabel) {
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

        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 0, 10, 0), null));

        game.addObserver(this);
    }

    @Override
    public void update(Observable obj, Object arg) {
        for (LabelGameInfo label : labels) {
            label.update(game);
        }
    }
}
