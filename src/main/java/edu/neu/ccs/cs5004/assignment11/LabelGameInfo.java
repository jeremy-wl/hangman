package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jeremy on 4/8/17.
 */
abstract class LabelGameInfo extends JLabel {
    protected static final Font LABEL_TEXT_FONT = new Font(Font.MONOSPACED, Font.BOLD, 16);

    protected abstract void update(GameState game);
}
