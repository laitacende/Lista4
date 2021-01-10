package cs.checkers.client.board;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.jupiter.api.Test;

/**
 * VisualBoardTest
 */
public class VisualBoardTest {

  @Test
  public void testValidMovement() {
    VisualBoard board = new VisualBoard();
    VisualField[][] fields = new VisualField[2][2];
    fields[0][0] = new VisualField(Color.BLACK);
    fields[1][1] = new VisualField(Color.BLACK);
    VisualChecker checker = new VisualChecker("x");
    fields[0][0].setChecker(checker);
    board.setFields(fields);
    board.move(0, 0, 1, 1);
    assertTrue(fields[0][0].getChecker() == null);
    assertTrue(fields[1][1].getChecker() == checker);
  }

  @Test
  public void testInvalidMovement() {
    VisualBoard board = new VisualBoard();
    VisualField[][] fields = new VisualField[2][2];
    fields[0][0] = new VisualField(Color.BLACK);
    fields[1][1] = new VisualField(Color.BLACK);
    VisualChecker checker = new VisualChecker("x");
    fields[0][0].setChecker(checker);
    board.setFields(fields);
    board.move(1, 1, 0, 0);
    assertTrue(fields[0][0].getChecker() == checker);
    assertTrue(fields[1][1].getChecker() == null);
  }
}
