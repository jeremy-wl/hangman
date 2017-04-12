package edu.neu.ccs.cs5004.assignment11;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
  public void update(Observable obj, Object arg) {
    repaint();
  }

  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    Image hangman = imageLibrary.getHangmanImage(game.getGuessesLeft());
    graphics.drawImage(hangman, 0, 0, this.getWidth(), this.getHeight(), this);
  }
}
