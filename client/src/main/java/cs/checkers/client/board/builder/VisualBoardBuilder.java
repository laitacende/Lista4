package cs.checkers.client.board.builder;

import cs.checkers.client.board.VisualBoard;
import cs.checkers.common.BoardTypes;

/**
 * VisualBoardBuilder
 */
public abstract class VisualBoardBuilder {
  public VisualBoard getBoard(BoardTypes type) {
    VisualBoard boardToReturn = new VisualBoard();
    fillWithCheckers(boardToReturn);
    return boardToReturn;
  }

  protected abstract void fillWithCheckers(VisualBoard boardToFill);

  //TODO: Implement function
  protected VisualBoard createBoard() {
    return new VisualBoard();
  }
}
