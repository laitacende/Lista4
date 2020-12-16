package cs.checkers.client.board.builder;


import cs.checkers.client.board.Coordinates;
import cs.checkers.client.board.VisualBoard;
import cs.checkers.client.board.VisualField;

/**
 * implements {@link VisualBoardBuilder} for a Chinese Checkers game of 2
 * players
 */
public class ThreePlayerVisualBoardBuilder extends VisualBoardBuilder {

  @Override
  protected void fillWithCheckers(VisualBoard boardToFill) {
    VisualField fields[][] = boardToFill.getFields();
    //upper triangle
    fillTriangleWithCheckers(0, 12, 4, Coordinates.DOWN, fields, "P");
    //lower right triangle
    fillTriangleWithCheckers(9, 21, 4, Coordinates.DOWN, fields, "P");
    //lower left triangle
    fillTriangleWithCheckers(9, 3, 4, Coordinates.DOWN, fields, "P");
  }
}
