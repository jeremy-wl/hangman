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

    GameState(String filePath) {
        possibleWords = FileReader.readWordsFromFile(filePath);
        resetGame();
    }

    void guessed(char c) {
        // One letter key = one guess, unless a player had hit the same key before
        if (wins() || lost() || !Character.isLetter(c) || guessedLetters.get(c)) return;
        guessesLeft--;
        guessedLetters.put(c, true);
        if (secretWordLetters.containsKey(c))   lettersAwayFromVictory--;
        setChanged();
        notifyObservers();
    }

    void resetGame() {
        secretWord = randomWord(possibleWords);
        secretWordLetters = stringToCharMap(secretWord);
        guessedLetters = stringToCharMap(ALL_POSSIBLE_LETTERS);
        guessesLeft = MAX_GUESSES_ALLOWED;
        lettersAwayFromVictory = secretWordLetters.size();
        setChanged();
        notifyObservers();
    }

    boolean wins() {
        return lettersAwayFromVictory == 0;
    }

    boolean lost() {
        return guessesLeft == 0;
    }

    Map<Character, Boolean> getSecretWordLetters() {
        return secretWordLetters;
    }

    Map<Character, Boolean> getGuessedLetters() {
        return guessedLetters;
    }

    int getGuessesLeft() {
        return guessesLeft;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public int getLettersAwayFromVictory() {
        return lettersAwayFromVictory;
    }

    /***************************** Private Methods *****************************/

    private String randomWord(String[] possibleWords) {
        Random random = new Random();
        int randomIndex = random.nextInt(possibleWords.length); // [0, len)
        return possibleWords[randomIndex];
    }

    private Map<Character, Boolean> stringToCharMap(String str) {
        Map<Character, Boolean> res = new HashMap<>();
        for (char c : str.toCharArray()) {
            res.put(c, false);
        }
        return res;
    }
}
