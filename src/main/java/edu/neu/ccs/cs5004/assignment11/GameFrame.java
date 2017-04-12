package edu.neu.ccs.cs5004.assignment11;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.Box;
import javax.swing.JFrame;

/**
 * Created by Jeremy on 4/11/17.
 */
class GameFrame extends JFrame {
  /**
   * Creates a frame container for the game where all components inside live.
   *
   * @param componentList a list of components that live inside
   */
  GameFrame(List<Component> componentList) {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());
    this.setContentPane(Box.createVerticalBox());
    this.setTitle("Hangman");

    for (Component component : componentList) {
      this.add(component);
    }

    this.getContentPane().setBackground(Color.WHITE);
    this.pack();
    this.setVisible(true);
  }
}
