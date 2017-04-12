package edu.neu.ccs.cs5004.assignment11;

import java.util.*;

/**
 * Created by Jeremy on 4/7/17.
 */
class GameState extends Observable {
    static final String ALL_POSSIBLE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    static final int MAX_GUESSES_ALLOWED = 6;

    private Map<Character, Boolean> secretWordLetters;
    private Map<Character, Boolean> guessedLetters;
    private int guessesLeft;
    private String[] possibleWords;

    private String secretWord;
    private int lettersAwayFromVictory;

    /**
     * Initialize the game state.
     * @param filePath the path of the text file that contains lines of words
     */
    GameState(String filePath) {
        possibleWords = FileReader.readWordsFromFile(filePath);
        resetGame();
    }

    /**
     * Updates the current game state given a character input from the player.
     * @param c the character input from the player
     */
    void guessed(char c) {
        // One letter key = one guess, unless a player had hit the same key before
        if (wins() || lost() || !Character.isLetter(c) || guessedLetters.get(c)) return;
        guessedLetters.put(c, true);
        if (secretWordLetters.containsKey(c))   lettersAwayFromVictory--;
        else                                    guessesLeft--;
        setChanged();
        notifyObservers();
    }

    /**
     * Resets all the game state data to their initial values.
     */
    void resetGame() {
        secretWord = randomWord(possibleWords);
        secretWordLetters = stringToCharMap(secretWord);
        guessedLetters = stringToCharMap(ALL_POSSIBLE_LETTERS);
        guessesLeft = MAX_GUESSES_ALLOWED;
        lettersAwayFromVictory = secretWordLetters.size();
        setChanged();
        notifyObservers();
    }

    /**
     * Returns true if the player wins the game, false otherwise.
     * @return true if the player wins the game, false otherwise
     */
    boolean wins() {
        return lettersAwayFromVictory == 0;
    }

    /**
     * Returns true if the player loses the game, false otherwise.
     * @return true if the player loses the game, false otherwise
     */
    boolean lost() {
        return guessesLeft == 0;
    }

    /**
     * Getter for property 'guessedLetters'.
     *
     * @return Value for property 'guessedLetters'.
     */
    Map<Character, Boolean> getGuessedLetters() {
        return guessedLetters;
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
    public String getSecretWord() {
        return secretWord;
    }

    /***************************** Private Methods *****************************/

    /**
     * Returns a random word from all possible words.
     * @param possibleWords the list of possible words read from the input file
     * @return a random word from all possible words
     */
    private String randomWord(String[] possibleWords) {
        Random random = new Random();
        int randomIndex = random.nextInt(possibleWords.length); // [0, len)
        return possibleWords[randomIndex];
    }

    /**
     * Converts the string to a map where the keys are unique characters
     * in the string, and values all initialized to false.
     * @param str the input string
     * @return a map where the keys are unique characters
     * in the string, and values all initialized to false.
     */
    private Map<Character, Boolean> stringToCharMap(String str) {
        Map<Character, Boolean> res = new HashMap<>();
        for (char c : str.toCharArray()) {
            res.put(c, false);
        }
        return res;
    }
}
