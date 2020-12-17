package cs.checkers.common;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * BoardTypesTest
 */
public class BoardTypesTest {
  @Test
  public void testEnumToPlayerNumber() {
    BoardTypes type = BoardTypes.TwoPlayerChineseCheckers;
    assertTrue(type.getNumOfPlayers(type) == 2);
  }

  @Test
  public void testStringToEnum() {
    BoardTypes type = BoardTypes.valueOf("TwoPlayerChineseCheckers");
    assertTrue(type.equals(BoardTypes.TwoPlayerChineseCheckers));
  }

  @Test
  public void testBoth() {
    BoardTypes type = BoardTypes.valueOf("TwoPlayerChineseCheckers");
    assertTrue(type.getNumOfPlayers(type) == 2);
  }
}
