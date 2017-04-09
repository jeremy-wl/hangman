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
        game = new GameState(filePath);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(new FlowLayout());
        frame.setContentPane(Box.createVerticalBox());
        frame.setTitle("Hangman");

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyKeyEventDispatcher());

        JLabel hangmanImage = new HangmanImage(game);
        frame.add(hangmanImage);

        GameInfoLabel secretWordLabel = new SecretWordLabel(game);
        GameInfoLabel guessedLettersLabel = new GuessedLettersLabel(game);
        GameInfoLabel guessesLeftLabel = new GuessesLeftLabel(game);
        JPanel gameInfoPanel = new GameInfoPanel(game, secretWordLabel, guessesLeftLabel, guessedLettersLabel);
        frame.add(gameInfoPanel);

        JButton newGameBtn = new JButton("New");
        newGameBtn.setActionCommand("New Game");
        newGameBtn.addActionListener(this);
        frame.add(newGameBtn);

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
