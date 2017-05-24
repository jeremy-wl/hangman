package edu.neu.ccs.cs5004.assignment11;

import java.util.*;

/**
 * Created by Jeremy on 4/7/17.
 */
class GameState extends Observable {
  static final String ALL_POSSIBLE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
  static final int MAX_GUESSES_ALLOWED = 6;

  private Set<Character> secretWordLetters;
  private Set<Character> unguessedLetters;
  private int guessesLeft;
  private String[] possibleWords;

  private String secretWord;

  /**
   * Initialize the game state.
   *
   * @param filePath the path of the text file that contains lines of words
   */
  GameState(String filePath) {
    possibleWords = WordsReader.readWordsFromFile(filePath);
    resetGame();
  }

  /**
   * Updates the current game state given a character input from the player.
   *
   * @param character the character input from the player
   */
  void guessed(char character) {

    if (wins() || lost() || !unguessedLetters.contains(character)) {
      return;
    }
    unguessedLetters.remove(character);
    if (secretWordLetters.contains(character)) {
      secretWordLetters.remove(character);
    } else {
      guessesLeft--;
    }
    setChanged();
    notifyObservers();
  }

  /**
   * Resets all the game state data to their initial values.
   */
  void resetGame() {
    secretWord = randomWord(possibleWords);
    secretWordLetters = stringToCharSet(secretWord);
    unguessedLetters  = stringToCharSet(ALL_POSSIBLE_LETTERS);
    guessesLeft = MAX_GUESSES_ALLOWED;
    setChanged();
    notifyObservers();
  }

  /**
   * Returns true if the player wins the game, false otherwise.
   *
   * @return true if the player wins the game, false otherwise
   */
  boolean wins() {
    return secretWordLetters.isEmpty();
  }

  /**
   * Returns true if the player loses the game, false otherwise.
   *
   * @return true if the player loses the game, false otherwise
   */
  boolean lost() {
    return guessesLeft == 0;
  }

  /**
   * Getter for property 'unguessedLetters'.
   *
   * @return Value for property 'unguessedLetters'.
   */
  Set<Character> getUnguessedLetters() {
    return unguessedLetters;
  }

  /**
   * Getter for property 'secretWordLetters'.
   *
   * @return Value for property 'secretWordLetters'.
   */
  Set<Character> getSecretWordLetters() {
    return secretWordLetters;
  }

  /**
   * Getter for property 'guessesLeft'.
   *
   * @return Value for property 'guessesLeft'.
   */
  int getGuessesLeft() {
    return guessesLeft;
  }

  /**
   * Getter for property 'secretWord'.
   *
   * @return Value for property 'secretWord'.
   */
  String getSecretWord() {
    return secretWord;
  }

  /**
   * Setter for property 'secretWord' (Method created for unit test).
   *
   * @param secretWord Value for property 'secretWord'.
   */
  public void setSecretWord(String secretWord) {
    this.secretWord = secretWord;
  }

  /**
   * Returns a random word from all possible words.
   *
   * @param possibleWords the list of possible words read from the input file
   * @return a random word from all possible words
   */
  private String randomWord(String[] possibleWords) {
    Random random = new Random();
    int randomIndex = random.nextInt(possibleWords.length); // [0, len)
    return possibleWords[randomIndex];
  }

  /**
   * Converts the string to a set of unique characters.
   *
   * @param str the input string
   * @return a set of unique characters
   */
  private Set<Character> stringToCharSet(String str) {
    Set<Character> res = new HashSet<>();
    for (char character : str.toCharArray()) {
      res.add(character);
    }
    return res;
  }
}
