package edu.neu.ccs.cs5004.assignment11;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeremy on 4/8/17.
 */
class HangmanImageLibrary {
    private Map<Integer, Image> hangmanImages;
    private static final String IMG_DIR = System.getProperty("user.dir")
            + "/src/main/java/edu/neu/ccs/cs5004/assignment11/images";

    public HangmanImageLibrary() {
        hangmanImages = new HashMap<>();
        for (int i = 0; i <= GameState.MAX_GUESSES_ALLOWED; i++) {
            try {
                Image image = ImageIO.read(new File(String.format("%s/Hangman%d.png", IMG_DIR, i)));
                hangmanImages.put(i, image);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    Image getHangmanImage(int guessesLeft) {
        return hangmanImages.get(guessesLeft);
    }
}
