package cs.checkers.client.board.factory;

import cs.checkers.client.board.VisualBoard;
import cs.checkers.common.BoardTypes;

/**
 * uses implementations of
 * {@link cs.checkers.client.board.builder.VisualBoardBuilder} to create a
 * {@link VisualBoard} of a given type in {@link BoardTypes}
 */
public class VisualBoardFactory {

  // TODO: implement function
  /**
     @param type the type that the resulting board is supposed to be
   */
  public VisualBoard getBoard(BoardTypes type) {
    return new VisualBoard();
  }
}
