package cs.checkers.client.board.builder;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.SwingConstants;

import cs.checkers.client.board.Coordinates;
import cs.checkers.client.board.VisualBoard;
import cs.checkers.client.board.VisualChecker;
import cs.checkers.client.board.VisualField;
import cs.checkers.common.BoardTypes;

import javax.imageio.ImageIO;
import javax.swing.*;

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

  private final Color availableColor = Color.LIGHT_GRAY;
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
    fillUpperTriangle(fields);
    // filling lower triangle with fields
    fillLowerTriangle(fields);
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
        fields[row][column].setEnabled(false);
        fields[row][column].setBorder(null);
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
        fields[row][column].setEnabled(false);
        fields[row][column].setBorder(null);
        column++;
      }
      incrementer += 2;
    }
  }

  private void fillLowerTriangle(VisualField fields[][]) {
    Integer incrementer = 1;
    for (Integer row = rows - 1; row >= rows - triangleHeight; row--) {
      int numberOfAvailableFieldsOnSide = (columns - incrementer) / 2;
      int column = 0;

      //right side
      while (column < numberOfAvailableFieldsOnSide) {
        if (fields[row][column] == null) {
          fields[row][column] = new VisualField(unavailableColor);
          fields[row][column].setEnabled(false);
          fields[row][column].setBorder(null);
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
          fields[row][column].setEnabled(false);
          fields[row][column].setBorder(null);
        }
        column++;
      }
      incrementer += 2;
    }
  }


  private VisualField makeInBoundsField(int row, int column) {
    Image buttonIcon = null;
    try {
      buttonIcon = ImageIO.read(getClass().getClassLoader().getResourceAsStream("field.png"));
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    buttonIcon = buttonIcon.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    Icon icon = new ImageIcon(buttonIcon);
    VisualField temp;
    if (row % 2 == 0) {
      if (column % 2 == 0) {
        // available
        temp = new VisualField(unavailableColor);
        temp.setIcon(icon);
        temp.setBorderPainted(false);
        temp.setPreferredSize(new Dimension(35, 35));
        temp.setMaximumSize(new Dimension(35,35));
        temp.setVerticalTextPosition(SwingConstants.CENTER);
        temp.setHorizontalTextPosition(SwingConstants.CENTER);
        return temp;
      } else {
        temp = new VisualField(unavailableColor);
        temp.setEnabled(false);
        temp.setBorder(null);
        return temp;
      }
    } else {
      if (column % 2 == 0) {
        temp = new VisualField(unavailableColor);
        temp.setEnabled(false);
        temp.setBorder(null);
        return temp;
      } else {
        // available
        temp = new VisualField(unavailableColor);
        temp.setBorderPainted(false);
        temp.setIcon(icon);
        temp.setPreferredSize(new Dimension(35, 35));
        temp.setMaximumSize(new Dimension(35,35));
        temp.setVerticalTextPosition(SwingConstants.CENTER);
        temp.setHorizontalTextPosition(SwingConstants.CENTER);
        return temp;
      }
    }
  }

  protected void fillTriangleWithCheckers(Integer rootPosX, Integer rootPosY, Integer triangleHeight,
                                          Integer triangleDirection, VisualField fields[][], String icon, Color color) {
    ArrayList<Coordinates> triangle = Coordinates.getTrianglePoints(rootPosX, rootPosY, triangleHeight,
        triangleDirection);
    int toSkip = 0;
    int amountOfPoints = 1;
    int index = 0;
    for (int row = 0; row < triangleHeight; row++) {
      int skipped = 0;
      for (int point = 0; point < amountOfPoints; point++) {
        Coordinates checkerField = triangle.get(index);
        fields[checkerField.getRow()][checkerField.getColumn()].setChecker(new VisualChecker(icon, color));
        index++;
        if (skipped < toSkip) {
          index++;
          skipped++;
        }
      }
      toSkip++;
      amountOfPoints += 1;
    }
  }
}
