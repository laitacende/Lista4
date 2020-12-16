package cs.checkers.client.board.builder;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import cs.checkers.client.board.Coordinates;
import cs.checkers.client.board.VisualBoard;
import cs.checkers.client.board.VisualField;

/**
 * implements {@link VisualBoardBuilder} for a Chinese Checkers game of 2
 * players
 */
public class TwoPlayerVisualBoardBuilder extends VisualBoardBuilder {

  @Override
  protected void fillWithCheckers(VisualBoard boardToFill) {
    VisualField fields[][] = boardToFill.getFields();
    //upper triangle
    fillTriangleWithCheckers(16, 12, 4, Coordinates.UP, fields, "P");
    //lower triangle
    fillTriangleWithCheckers(0, 12, 4, Coordinates.DOWN, fields, "P");
  }
}
