package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;

/**
 * Created by Jeremy on 4/8/17.
 */
abstract class LabelGameInfo extends JLabel {
    protected abstract void update(GameState game);
}
