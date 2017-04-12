package edu.neu.ccs.cs5004.assignment11;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Jeremy on 4/11/17.
 */
public class GameStateTest {
    private static final String dir = System.getProperty("user.dir") +
            "/src/main/java/edu/neu/ccs/cs5004/assignment11/";
    private static final String fileName = "words.txt";
    private GameState game;
    private Map<Character, Boolean> guessedLetters;

    @Before
    public void setUp() throws Exception {
        game = new GameState(dir + fileName);
        guessedLetters = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            guessedLetters.put(c, false);
        }
    }

    @Test
    public void testGuessed() throws Exception {
        game.setSecretWord("hello");
        game.guessed('l');
        game.guessed('p');
        game.guessed('h');

        guessedLetters.put('h', true);
        guessedLetters.put('p', true);
        guessedLetters.put('l', true);
        Assert.assertEquals(guessedLetters, game.getGuessedLetters());
    }
}
