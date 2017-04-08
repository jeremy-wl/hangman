package edu.neu.ccs.cs5004.assignment11;

import java.util.*;

/**
 * Created by Jeremy on 4/7/17.
 */
class GameState extends Observable {
    private Map<Character, Boolean> secretWordLetters;
    private Map<Character, Boolean> guessedLetters;
    private int guessesLeft;
    private String[] possibleWords;
    private String secretWord;
    static final String ALL_POSSIBLE_LETTERS = "abcdefghijklmnopqrstuvwxyz";

    GameState(String filePath) {
        possibleWords = FileReader.readWordsFromFile(filePath);
        resetGame();
    }

    void guessed(char c) {
        if (!Character.isLetter(c)) return;

        // One letter key = one guess, unless a player had hit the same key before
        if (!guessedLetters.get(c)) guessesLeft--;

        guessedLetters.put(c, true);
        setChanged();
        notifyObservers();
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

    /***************************** Private Methods *****************************/

    private void resetGame() {
        secretWord = randomWord(possibleWords);
        secretWordLetters = stringToCharMap(secretWord);
        guessedLetters = stringToCharMap(ALL_POSSIBLE_LETTERS);
        guessesLeft = secretWord.length();
    }

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
