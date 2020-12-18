package cs.checkers.client.board.builder;

import cs.checkers.client.board.Coordinates;
import cs.checkers.client.board.VisualBoard;
import java.awt.Color;

/**
 * implements {@link VisualBoardBuilder} for a Chinese Checkers game of 2
 * players
 */
public class SixPlayerVisualBoardBuilder extends VisualBoardBuilder {
  private static final Color[] checkerColors = { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW, Color.BLACK };

  @Override
  protected void fillWithCheckers(VisualBoard boardToFill) {
    // upper triangle
    fillTriangleWithCheckers(0, 12, 4, Coordinates.DOWN, boardToFill.getFields(), "O", checkerColors[0]);
    // upper left triangle
    fillTriangleWithCheckers(7, 3, 4, Coordinates.UP, boardToFill.getFields(), "O", checkerColors[1]);
    // upper right triangle
    fillTriangleWithCheckers(7, 21, 4, Coordinates.UP, boardToFill.getFields(), "O", checkerColors[2]);
    // lower left triangle
    fillTriangleWithCheckers(9, 3, 4, Coordinates.DOWN, boardToFill.getFields(), "O", checkerColors[3]);
    // lower right triangle
    fillTriangleWithCheckers(9, 21, 4, Coordinates.DOWN, boardToFill.getFields(), "O", checkerColors[4]);
    // lower triangle
    fillTriangleWithCheckers(16, 12, 4, Coordinates.UP, boardToFill.getFields(), "O", checkerColors[5]);
  }

}
