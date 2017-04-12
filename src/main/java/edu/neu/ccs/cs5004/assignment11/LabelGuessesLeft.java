package edu.neu.ccs.cs5004.assignment11;


/**
 * Created by Jeremy on 4/8/17.
 */
class LabelGuessesLeft extends LabelGameInfo {

    /**
     * Creates the guesses left label given the current game state.
     * @param game the current game state
     */
    LabelGuessesLeft(GameState game) {
        this.setFont(LABEL_TEXT_FONT);

        int guesses = game.getGuessesLeft();
        String message = String.format("%s guesses left", guesses);
        this.setText(message);
    }

    @Override
    public void update(GameState game) {
        int guesses = game.getGuessesLeft();
        String message = String.format("%s guesses left", guesses);

        if (game.wins())        message = String.format("You won with %s", message);
        else if (game.lost())   message = String.format("You lost! (%s)", game.getSecretWord());

        this.setText(message);
    }
}
