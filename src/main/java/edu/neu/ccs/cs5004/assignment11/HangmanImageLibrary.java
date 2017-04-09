package edu.neu.ccs.cs5004.assignment11;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeremy on 4/8/17.
 */
class HangmanImageLibrary {
    private Map<Integer, ImageIcon> hangmanImages;  // TODO: change value to Image
    private static final String IMG_DIR = System.getProperty("user.dir")
            + "/src/main/java/edu/neu/ccs/cs5004/assignment11/images";

    public HangmanImageLibrary() {
        hangmanImages = new HashMap<>();
        for (int i = 0; i <= GameState.MAX_GUESSES_ALLOWED; i++) {  // TODO: exception
            ImageIcon img = new ImageIcon(String.format("%s/Hangman%d.png", IMG_DIR, i));
            hangmanImages.put(i, img);
        }
    }

    ImageIcon getHangmanImage(int guessesLeft) {
        return hangmanImages.get(guessesLeft);
    }
}
