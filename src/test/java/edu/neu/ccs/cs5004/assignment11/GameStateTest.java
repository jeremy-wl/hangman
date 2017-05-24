package edu.neu.ccs.cs5004.assignment11;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jeremy on 4/11/17.
 */
public class GameStateTest {
  private static final String dir = System.getProperty("user.dir") +
          "/src/main/java/edu/neu/ccs/cs5004/assignment11/";
  private static final String fileName = "words.txt";
  private GameState game;
  private Set<Character> unguessedLetters;

  @Before
  public void setUp() throws Exception {
    game = new GameState(dir + fileName);
    unguessedLetters = new HashSet<>();
    for (char c = 'a'; c <= 'z'; c++) {
      unguessedLetters.add(c);
    }
  }

  @Test
  public void testGuessed() throws Exception {
    game.setSecretWord("hello");
    game.guessed('*');
    Assert.assertTrue(game.getSecretWordLetters().contains('l'));
    Assert.assertTrue(game.getUnguessedLetters().contains('l'));
    game.guessed('l');
    Assert.assertFalse(game.getUnguessedLetters().contains('l'));
    Assert.assertFalse(game.getSecretWordLetters().contains('l'));
    Assert.assertEquals("hello", game.getSecretWord());
  }
}
