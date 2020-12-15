package cs.checkers.client.board.builder;

import cs.checkers.client.board.VisualBoard;
import cs.checkers.common.BoardTypes;

/**
 * {@link VisualBoard} builder, fills the {@link VisualBoard} with
 * {@link cs.checkers.client.board.VisualField} and
 * {@link cs.checkers.client.board.VisualChecker}. It's extremely important,
 * that there is an implementation of this class for each type in
 * {@link BoardTypes}
 */
public abstract class VisualBoardBuilder {
  public VisualBoard getBoard(BoardTypes type) {
    VisualBoard boardToReturn = new VisualBoard();
    fillWithCheckers(boardToReturn);
    return boardToReturn;
  }

  protected abstract void fillWithCheckers(VisualBoard boardToFill);

  // TODO: Implement function
  /**
   * this function assumes the game is Chinese Checkers, so it creates a
   * {@link VisualBoard} shaped like a hexagram
   */
  protected VisualBoard createBoard() {
    return new VisualBoard();
  }
}
