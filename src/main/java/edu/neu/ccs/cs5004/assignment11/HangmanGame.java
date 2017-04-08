package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Jeremy on 4/7/17.
 */
public class HangmanGame {
    private GameState game;

    private class MyKeyEventDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_TYPED) {
                char pressedKey = e.getKeyChar();
                System.out.printf("You pressed %s \n", pressedKey);
                game.guessed(pressedKey);
            }
            return false;
        }
    }

    private HangmanGame(String filePath) {
        game = new GameState(filePath);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setContentPane(Box.createVerticalBox());
        frame.setTitle("Hangman");

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyKeyEventDispatcher());

        SecretWordLabel secretWordLabel = new SecretWordLabel(game);
        GuessedLettersLabel guessedLettersLabel = new GuessedLettersLabel(game);
        GuessesLeftLabel guessesLeftLabel = new GuessesLeftLabel(game);

        JPanel gameInfoPanel = new GameInfoPanel(game, secretWordLabel, guessesLeftLabel, guessedLettersLabel);

        frame.add(gameInfoPanel);

        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        String dir = System.getProperty("user.dir") +
                "/src/main/java/edu/neu/ccs/cs5004/assignment11/";
        String fileName = "words.txt";
        new HangmanGame(dir + fileName);
    }
}
