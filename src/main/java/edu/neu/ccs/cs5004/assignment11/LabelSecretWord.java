package edu.neu.ccs.cs5004.assignment11;


/**
 * Created by Jeremy on 4/8/17.
 */
class LabelSecretWord extends LabelGameInfo {
  private static final char UNGUESSED_SIGN = '?';

  /**
   * Creates the secret word label given the current game state.
   *
   * @param game the current game state
   */
  LabelSecretWord(GameState game) {
    this.setFont(LABEL_TEXT_FONT);

    StringBuilder secretString = new StringBuilder();
    for (int i = 0; i < game.getSecretWord().length(); i++) {
      secretString.append(UNGUESSED_SIGN);
    }

    this.setText(secretString.toString());
  }

  @Override
  public void update(GameState game) {
    StringBuilder secretString = new StringBuilder();

    for (char wordLetter : game.getSecretWord().toCharArray()) {
      char character = game.getGuessedLetters().get(wordLetter) ? wordLetter : UNGUESSED_SIGN;
      secretString.append(character);
    }

    this.setText(secretString.toString());
  }
}
