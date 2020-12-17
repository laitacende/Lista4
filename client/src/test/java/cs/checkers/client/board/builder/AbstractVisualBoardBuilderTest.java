package cs.checkers.client.board.builder;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cs.checkers.client.board.VisualBoard;

/**
 * AbstractVisualBoardBuilderTest
 */
public abstract class AbstractVisualBoardBuilderTest {
  @Test
  public void testBoardCreation() {
    VisualBoard board = createBoard();
    assertTrue(board != null);
  }

  protected abstract VisualBoard createBoard();
}
