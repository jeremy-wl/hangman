# Hangman Game

This program was an assignment of the [Object Oriented Design and Analysis](http://www.ccs.neu.edu/home/skotthe/classes/cs5004/Spring/2017/syllabus.html) Course. The design follows the observer pattern.

## [Problem Description](http://www.ccs.neu.edu/home/skotthe/classes/cs5004/Spring/2017/assignment/7/hangman.pdf)

Hangman is a simple game where a player attempts to guess a secret word by picking letters from the alphabet.
1. Each time the game begins, a random word is chosen from the provided words.txt file
2. The chosen/secret word appears as a series of ? (question marks), one for each letter in the secret word.
3. A player should try to guess a letter by simply pressing (i.e. typing) the respective key on the keyboard.
4. The letter that the player has pressed becomes blue (initially all the letters are light gray).
5. One letter key = one guess, unless a player had hit the same key before.
6. If the player guesses a letter that occurs in the secret word, all occurrences of that letter will appear, changing from question marks into the correct letter.
7. If the player guesses a letter that does not occur in the secret word, the player uses up one guess (the number of remaining guesses is updated), and a portion of the hangman’s body appears.
8. If the player correctly guesses all the letters in the secret word before running out of guesses, he/she wins the game.
9. If all guesses are used up, the hangman’s entire body appears and the player loses the game.
10. The player may start playing again by pressing the New button.

## Running the program

Run **src/main/java/edu/neu/ccs/cs5004/assignment11/HangmanGame.java** to start the game. When game starts, you may type letters on the keyboard or hit "New" button to restart the game.