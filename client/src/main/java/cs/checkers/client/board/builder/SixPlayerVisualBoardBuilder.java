package cs.checkers.client.board.builder;

import cs.checkers.client.board.Coordinates;
import cs.checkers.client.board.VisualBoard;

/**
 * implements {@link VisualBoardBuilder} for a Chinese Checkers game of 2
 * players
 */
public class SixPlayerVisualBoardBuilder extends VisualBoardBuilder {

  @Override
  protected void fillWithCheckers(VisualBoard boardToFill) {
    // upper triangle
    fillTriangleWithCheckers(0, 12, 4, Coordinates.DOWN, boardToFill.getFields(), "P");
    // upper left triangle
    fillTriangleWithCheckers(7, 3, 4, Coordinates.UP, boardToFill.getFields(), "P");
    // upper right triangle
    fillTriangleWithCheckers(7, 21, 4, Coordinates.UP, boardToFill.getFields(), "P");
    // lower left triangle
    fillTriangleWithCheckers(9, 3, 4, Coordinates.DOWN, boardToFill.getFields(), "P");
    // lower right triangle
    fillTriangleWithCheckers(9, 21, 4, Coordinates.DOWN, boardToFill.getFields(), "P");
    // lower triangle
    fillTriangleWithCheckers(16, 12, 4, Coordinates.UP, boardToFill.getFields(), "P");
  }

}
