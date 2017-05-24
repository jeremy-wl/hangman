package edu.neu.ccs.cs5004.assignment11;

import java.util.Set;

/**
 * Created by Jeremy on 4/8/17.
 */
class LabelGuessedLetters extends LabelGameInfo {
  private static final String GUESSED_COLOR = "blue";
  private static final String UNGUESSED_COLOR = "gray";

  /**
   * Creates the guessed letters label given the current game state.
   *
   * @param game the current game state
   */
  LabelGuessedLetters(GameState game) {
    this.setFont(LABEL_TEXT_FONT);
    this.setText(htmlFlavoredText(game.getUnguessedLetters()));
  }

  @Override
  public void update(GameState game) {
    this.setText(htmlFlavoredText(game.getUnguessedLetters()));
  }

  /**
   * Given a color attribute value in HTML and a character, returns a StringBuilder object
   * containing the character surrounded by html font tag with the color attribute included.
   *
   * @param color     a color attribute value in HTML
   * @param character a character
   *
   * @return a StringBuilder object containing the character surrounded by html font tag
   *         with the color attribute included.
   */
  private StringBuilder wrapColoredTextWithHtmlTags(String color, char character) {
    StringBuilder res = new StringBuilder();
    res.append("<font color=").append(color).append(">");
    res.append(character);
    res.append("</font>");
    return res;
  }

  /**
   * Given a set of unguessed letters, returns the HTML code with each character surrounded by
   * a font tag with the color attribute included.
   *
   * @param unguessedLetters the set of unguessed letters
   *
   * @return the HTML code with each character surrounded by
   *         a font tag with the color attribute included.
   */
  private String htmlFlavoredText(Set<Character> unguessedLetters) {
    StringBuilder text = new StringBuilder();
    text.append("<html>");
    for (char c : GameState.ALL_POSSIBLE_LETTERS.toCharArray()) {
      if (unguessedLetters.contains(c)) {
        text.append(wrapColoredTextWithHtmlTags(UNGUESSED_COLOR, c));
      } else {
        text.append(wrapColoredTextWithHtmlTags(GUESSED_COLOR, c));
      }
    }
    text.append("</html>");
    return text.toString();
  }
}
