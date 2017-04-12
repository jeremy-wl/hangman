package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeremy on 4/7/17.
 */
public class HangmanGame implements ActionListener {
  private GameState game;
  private JFrame gameFrame;

  /**
   * Given a file path, reads all words inside and
   * initializes the Hangman game.
   *
   * @param filePath the path of the file that contains all possible words.
   */
  private HangmanGame(String filePath) {
    // initialize the GameState model from a text file containing words (on each line)
    game = new GameState(filePath);
    List<Component> components = new ArrayList<>();

    // setting up key event dispatcher to get user keyboard inputs
    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
    manager.addKeyEventDispatcher(new MyKeyEventDispatcher());

    // adding the panel for hangman image
    JPanel hangmanImage = new PanelHangmanImage(game);
    components.add(hangmanImage);

    // adding an info panel with 3 labels inside
    LabelGameInfo secretWordLabel = new LabelSecretWord(game);
    LabelGameInfo guessedLettersLabel = new LabelGuessedLetters(game);
    LabelGameInfo guessesLeftLabel = new LabelGuessesLeft(game);
    JPanel gameInfoPanel = new PanelGameInfo(game, secretWordLabel, guessesLeftLabel,
            guessedLettersLabel);
    components.add(gameInfoPanel);

    // adding the new game button at the bottom to a panel and then to the frame
        /* TODO: extracting the JPanel out and putting its reference in frame.add() will
                 cause the button text render incorrectly, WHY? */
    JButton newGameBtn = new ButtonNewGame(this);
    components.add(new JPanel().add(newGameBtn));

    // setting up the frame with all components (panels, buttons) added
    gameFrame = new GameFrame(components);
  }

  public static void main(String[] args) {
    String dir = System.getProperty("user.dir") +
            "/src/main/java/edu/neu/ccs/cs5004/assignment11/";
    String fileName = "words.txt";

    javax.swing.SwingUtilities.invokeLater(() -> new HangmanGame(dir + fileName));
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    JButton src = (JButton) event.getSource();

    if (src.getActionCommand().equals("New Game"))
      game.resetGame();
  }

  /**
   * Represents a key event dispatcher class that captures characters from
   * the user keyboard input.
   */
  private class MyKeyEventDispatcher implements KeyEventDispatcher {
    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
      if (e.getID() == KeyEvent.KEY_TYPED) {
        char pressedKey = e.getKeyChar();
        game.guessed(pressedKey);
      }
      return false;
    }
  }
}
