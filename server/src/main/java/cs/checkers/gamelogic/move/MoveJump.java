package cs.checkers.gamelogic.move;

import java.util.ArrayList;
import java.util.List;

import cs.checkers.gamelogic.board.Board;
import cs.checkers.gamelogic.field.Field;

/**
 * Class which represents 'jumping move' of checker.
 */
public class MoveJump extends Move {
  private final Integer offsetX[] = { -1, -1, 1, 1, 0, 0 };
  private final Integer offsetY[] = { -1, 1, 1, -1, 2, -2 };

  /**
   * Method which validates move for 'move jump'.
   * 
   * @param x1    current field row
   * @param y1    current field column
   * @param x2    next field row
   * @param y2    next field column
   * @param board up-to-date board
   * 
   * @return true if move is valid, otherwise false
   */
  @Override
  public boolean validateMove(Integer x1, Integer y1, Integer x2, Integer y2, Board board) {
    ArrayList<Field> visited = new ArrayList<Field>();
    if (recursiveValidateMove(x1, y1, x2, y2, board, visited)) {
      return true;
    } else {
      return false;
    }
  }

  private boolean recursiveValidateMove(Integer x1, Integer y1, Integer x2, Integer y2, Board board,
      List<Field> visitedFields) {
    visitedFields.add(board.getField(x1, y1));
    for (int probe = 0; probe < offsetX.length; probe++) {
      Integer offX1 = x1 + offsetX[probe];
      Integer offY1 = y1 + offsetY[probe];
      Integer twiceOffX1 = x1 + (2 * offsetX[probe]);
      Integer twiceOffY1 = y1 + (2 * offsetY[probe]);
      try {
        // try to find if neighbor has checker;
        if (board.getField(offX1, offY1).getChecker() != null) {
          // try to find if field behind neighbour doesn't have a checker
          if (board.getField(twiceOffX1, twiceOffY1).getChecker() == null) {
            // check that we haven't visited this destination yet
            if (listContains(visitedFields, board.getField(twiceOffX1, twiceOffY1))) {
              continue;
            }
            // if we reached the destination return true
            if (twiceOffX1 == x2 && twiceOffY1 == y2) {
              return true;
            } else {
              // check if we can get to target destination from this field
              if (recursiveValidateMove(twiceOffX1, twiceOffY1, x2, y2, board, visitedFields)) {
                return true;
              } else {
                continue;
              }
            }
          }
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        continue;
      } catch (NullPointerException e) {
        continue;
      }

    }
    return false;
  }

  private boolean listContains(List<Field> fields, Field field) {
    for (Field f : fields) {
      if (f == field) {
        return true;
      }
    }
    return false;
  }
}
