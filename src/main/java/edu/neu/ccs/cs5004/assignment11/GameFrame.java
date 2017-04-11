package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Jeremy on 4/11/17.
 */
public class GameFrame extends JFrame {
    public GameFrame(List<Component> componentList) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setContentPane(Box.createVerticalBox());
        this.setTitle("Hangman");

        for (Component component : componentList)   {
            this.add(component);
        }

        this.getContentPane().setBackground(Color.WHITE);
        this.pack();
        this.setVisible(true);
    }
}
