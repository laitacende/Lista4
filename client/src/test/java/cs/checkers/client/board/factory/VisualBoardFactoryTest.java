package cs.checkers.client.board.factory;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cs.checkers.client.board.VisualBoard;
import cs.checkers.common.BoardTypes;

/**
 * VisualBoardFactoryTest
 */
public class VisualBoardFactoryTest {

  @Test
  public void testTwo() {
    VisualBoard board = VisualBoardFactory.getBoard(BoardTypes.TwoPlayerChineseCheckers);
    assertTrue(board != null);
  }

  @Test
  public void testThree() {
    VisualBoard board = VisualBoardFactory.getBoard(BoardTypes.ThreePlayerChineseCheckers);
    assertTrue(board != null);
  }

  @Test
  public void testFour() {
    VisualBoard board = VisualBoardFactory.getBoard(BoardTypes.FourPlayerChineseCheckers);
    assertTrue(board != null);
  }

  @Test
  public void testSix() {
    VisualBoard board = VisualBoardFactory.getBoard(BoardTypes.SixPlayerChineseCheckers);
    assertTrue(board != null);
  }
}
