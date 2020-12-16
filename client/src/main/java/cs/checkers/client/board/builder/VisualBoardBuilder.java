package cs.checkers.client.board.builder;

import java.awt.Color;

import cs.checkers.client.board.VisualBoard;
import cs.checkers.client.board.VisualField;
import cs.checkers.common.BoardTypes;

/**
 * {@link VisualBoard} builder, fills the {@link VisualBoard} with
 * {@link cs.checkers.client.board.VisualField} and
 * {@link cs.checkers.client.board.VisualChecker}. It's extremely important,
 * that there is an implementation of this class for each type in
 * {@link BoardTypes}
 */
public abstract class VisualBoardBuilder {
  public VisualBoard getBoard() {
    VisualBoard boardToReturn = createBoard();
    fillWithCheckers(boardToReturn);
    return boardToReturn;
  }

  private final Color availableColor = Color.GREEN;
  private final Color unavailableColor = Color.GRAY;
  protected final Integer rows = 17;
  protected final Integer columns = 25;
  private final Integer triangleHeight = 13;

  protected abstract void fillWithCheckers(VisualBoard boardToFill);

  /**
   * this function assumes the game is Chinese Checkers, so it creates a
   * {@link VisualBoard} shaped like a hexagram with standard matrix dimensions
   * 25x17 if a specific implementation wants to have a different size, it needs
   * to overwrite this function
   */
  protected VisualBoard createBoard() {
    VisualField fields[][] = new VisualField[rows][columns];
    // filling upper triangle with fields
    System.out.println("Filling upper triangle");
    fillUpperTriangle(fields);
    // filling lower triangle with fields
    System.out.println("Filling lower triangle");
    fillLowerTriangle(fields);
    System.out.println("Triangles filled");
    VisualBoard board = new VisualBoard();
    board.setFields(fields);
    return board;
  }

  private void fillUpperTriangle(VisualField fields[][]) {
    Integer incrementer = 1;
    for (Integer row = 0; row < triangleHeight; row++) {
      int numberOfAvailableFieldsOnSide = (columns - incrementer) / 2;
      Integer column = 0;

      // left side unavailable fields (out of bounds)
      while (column < numberOfAvailableFieldsOnSide) {
        fields[row][column] = new VisualField(unavailableColor);
        column++;
      }

      // middle in bounds fields
      for (int counter = 0; counter < incrementer; counter++) {
        fields[row][column] = makeInBoundsField(row, column);
        column++;
      }

      // right side out of bounds
      while (column < fields[row].length) {
        fields[row][column] = new VisualField(unavailableColor);
        column++;
      }
      incrementer += 2;
    }
  }

  private void fillLowerTriangle(VisualField fields[][]) {
    Integer incrementer = 1;
    for (Integer row = rows - 1; row >= rows - triangleHeight; row--) {
      int numberOfAvailableFieldsOnSide = (columns - incrementer) / 2;
      System.out.println(numberOfAvailableFieldsOnSide);
      int column = 0;

      //right side
      while (column < numberOfAvailableFieldsOnSide) {
        if (fields[row][column] == null) {
          fields[row][column] = new VisualField(unavailableColor);
        }
        column++;
      }

      //middle
      for (int counter = 0; counter < incrementer; counter++) {
          fields[row][column] = makeInBoundsField(row, column);
        column++;
      }

      //right side
      while (column < fields[row].length) {
        if (fields[row][column] == null) {
          fields[row][column] = new VisualField(unavailableColor);
        }
        column++;
      }
      incrementer += 2;
    }
  }


  private VisualField makeInBoundsField(int row, int column) {
    if (row % 2 == 0) {
      if (column % 2 == 0) {
        return new VisualField(availableColor);
      } else {
        return new VisualField(unavailableColor);
      }
    } else {
      if (column % 2 == 0) {
        return new VisualField(unavailableColor);
      } else {
        return new VisualField(availableColor);
      }
    }
  }
}
