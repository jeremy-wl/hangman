package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jeremy on 4/8/17.
 */
class PanelHangmanImage extends JPanel implements Observer {
  private static final Dimension IMAGE_PANEL_SIZE = new Dimension(400, 504);

  private GameState game;
  private HangmanImageLibrary imageLibrary;

  /**
   * Creates a JPanel where the hangman image is located.
   *
   * @param game the current game state
   */
  PanelHangmanImage(GameState game) {
    this.game = game;

    this.imageLibrary = new HangmanImageLibrary();
    this.setPreferredSize(IMAGE_PANEL_SIZE);
    this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 0, 0, 0), null));
    this.game.addObserver(this);
  }

  @Override
  public void update(Observable o, Object arg) {
    repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Image hangman = imageLibrary.getHangmanImage(game.getGuessesLeft());
    g.drawImage(hangman, 0, 0, this.getWidth(), this.getHeight(), this);
  }
}
