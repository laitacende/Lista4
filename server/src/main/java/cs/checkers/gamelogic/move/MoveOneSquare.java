package cs.checkers.gamelogic.move;

import cs.checkers.gamelogic.board.Board;

/**
 * Class which represents move to field adjacent to current field.
 */
public class MoveOneSquare extends Move {


  /**
   * Method which validates move for 'move one square'.
   * 
   * @param x1 current field row
   * @param y1 current field column
   * @param x2 next field row
   * @param y2 next field column
   * @return true if move is possible, otherwise false
   */
  @Override
  public boolean validateMove(Integer x1, Integer y1, Integer x2, Integer y2, Board board) {
    if ((Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 1) || (Math.abs(y1 - y2) == 2 && x1 - x2 == 0)) {
      return true;
    }
    return false;
  }
}
