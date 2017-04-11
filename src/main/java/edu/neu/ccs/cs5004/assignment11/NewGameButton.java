package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Jeremy on 4/11/17.
 */
public class NewGameButton extends JButton {
    public static final Dimension NEW_GAME_BTN_SIZE = new Dimension(40, 40);
    public static final Font NEW_GAME_BTN_FONT = new Font("Arial", Font.PLAIN, 20);

    public NewGameButton(ActionListener listener) {
        super("New");  // text showing on the button
        this.setActionCommand("New Game");
        this.addActionListener(listener);
        this.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setPreferredSize(NEW_GAME_BTN_SIZE);
        this.setFont(NEW_GAME_BTN_FONT);
    }
}
