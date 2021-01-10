package cs.checkers.client.board.builder;

import cs.checkers.client.board.Coordinates;
import cs.checkers.client.board.VisualBoard;
import cs.checkers.client.board.VisualField;
import java.awt.Color;

/**
 * implements {@link VisualBoardBuilder} for a Chinese Checkers game of 2
 * players
 */
public class TwoPlayerVisualBoardBuilder extends VisualBoardBuilder {
  private static final Color[] checkerColors = {Color.BLUE, Color.GREEN};

  @Override
  protected void fillWithCheckers(VisualBoard boardToFill) {
    VisualField fields[][] = boardToFill.getFields();
    //upper triangle
    fillTriangleWithCheckers(16, 12, 4, Coordinates.UP, fields, "O", checkerColors[0]);
    //lower triangle
    fillTriangleWithCheckers(0, 12, 4, Coordinates.DOWN, fields, "O", checkerColors[1]);
  }
}
