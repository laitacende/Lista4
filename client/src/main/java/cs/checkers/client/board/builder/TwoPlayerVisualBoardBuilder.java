package cs.checkers.client.board.builder;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import cs.checkers.client.board.VisualBoard;
import cs.checkers.client.board.VisualChecker;
import cs.checkers.client.board.VisualField;

/**
 * implements {@link VisualBoardBuilder} for a Chinese Checkers game of 2
 * players
 */
public class TwoPlayerVisualBoardBuilder extends VisualBoardBuilder {

  @Override
  protected void fillWithCheckers(VisualBoard boardToFill) {
    VisualField fields[][] = boardToFill.getFields();

    // upper corner
    int incrementer = 1;
    for (int row = 0; row < 4; row++) {
      int numberOfAvailableFieldsOnSide = (fields[row].length - incrementer) / 2;
      for (int column = numberOfAvailableFieldsOnSide; column <
             numberOfAvailableFieldsOnSide + incrementer; column += 2) {
        fields[row][column].setChecker(new VisualChecker("P"));
      }
      incrementer += 2;
    }
    // lower corner
    incrementer -= 2;
    for (int row = 13; row < 17; row++) {
      int numberOfAvailableFieldsOnSide = (fields[row].length - incrementer) / 2;
      
      for (int column = numberOfAvailableFieldsOnSide; column <
             numberOfAvailableFieldsOnSide + incrementer; column += 2) {
        fields[row][column].setChecker(new VisualChecker("P"));
      }
      incrementer -= 2;
    }
  }
}
