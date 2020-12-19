package cs.checkers.gamelogic.move;

import cs.checkers.gamelogic.board.Board;

/**
 * Class which represents move.
 */
public abstract class Move {
  public abstract boolean validateMove(Integer x1, Integer y1, Integer x2, Integer y2, Board board);
}
