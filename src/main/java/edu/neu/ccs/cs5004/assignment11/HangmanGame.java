package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Jeremy on 4/7/17.
 */
public class HangmanGame implements ActionListener {
    private GameState game;

    private class MyKeyEventDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_TYPED) {
                char pressedKey = e.getKeyChar();
                System.out.printf("You pressed %s \n", pressedKey);  // TODO: remove this line
                game.guessed(pressedKey);
            }
            return false;
        }
    }

    private HangmanGame(String filePath) {
        // initialize the GameState model from a text file containing words (on each line)
        game = new GameState(filePath);

        // setting up the frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(new FlowLayout());
        frame.setContentPane(Box.createVerticalBox());
        frame.setTitle("Hangman");

        // setting up key event dispatcher to get user keyboard inputs
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyKeyEventDispatcher());

        // adding the panel for hangman image
        JPanel hangmanImage = new HangmanImage(game);
        frame.add(hangmanImage);

        // adding an info panel with 3 labels inside
        GameInfoLabel secretWordLabel = new SecretWordLabel(game);
        GameInfoLabel guessedLettersLabel = new GuessedLettersLabel(game);
        GameInfoLabel guessesLeftLabel = new GuessesLeftLabel(game);
        JPanel gameInfoPanel = new GameInfoPanel(game, secretWordLabel, guessesLeftLabel, guessedLettersLabel);
        frame.add(gameInfoPanel);

        // adding the new game button at the bottom to a panel and then to the frame
        /* TODO: extracting the JPanel out and putting its reference in frame.add() will
                 cause the button text render incorrectly, WHY? */
        JButton newGameBtn = new NewGameButton(this);
        frame.add(new JPanel().add(newGameBtn));

        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton src = (JButton) event.getSource();

        if (src.getActionCommand().equals("New Game"))
            game.resetGame();
    }

    public static void main(String[] args) {
        String dir = System.getProperty("user.dir") +
                "/src/main/java/edu/neu/ccs/cs5004/assignment11/";
        String fileName = "words.txt";
        new HangmanGame(dir + fileName);
    }
}
