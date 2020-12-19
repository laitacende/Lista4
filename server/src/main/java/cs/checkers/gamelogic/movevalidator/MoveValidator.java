package cs.checkers.gamelogic.movevalidator;

import cs.checkers.common.CommandParser;
import cs.checkers.gamelogic.board.Board;
import cs.checkers.gamelogic.checker.Checker;
import cs.checkers.gamelogic.checker.ChineseBasicChecker;
import cs.checkers.gamelogic.field.Field;
import cs.checkers.gamelogic.field.UnavailableField;
import cs.checkers.gamelogic.move.Move;
import cs.checkers.gamelogic.move.MoveJump;
import cs.checkers.gamelogic.move.MoveOneSquare;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which validates moves of checkers.
 */
public class MoveValidator {
    /**
     * List of visited fields.
     */
    private List<Field> visited = new ArrayList<>();

    /**
     * Values to iterate through neighbours for x axis.
     */
    private final Integer[] valx = {-1, 0, 1, 1, 0, -1};

    /**
     * Values to iterate through neighbours for y axis.
     */
    private final Integer[] valy = {1, 2, 1, -1, -2, -1};

    /**
     * Method which validates move specified in given command.
     * @param x1 row of current field
     * @param y1 column of current field
     * @param x2 row of next field
     * @param y2 column of next field
     * @param board up-to-date board
     * @return true if move is valid, false otherwise
     */
    public boolean validateMove(int x1, int y1, int x2, int y2, Board board) { // command in format 'move x_1,y_1 x_2,y_2'
        visited.clear();

        Field currentField = board.getField(x1, y1);
        Field nextField = board.getField(x2, y2);
        Checker checker = currentField.getChecker();

        if (nextField.equals(currentField)) {
            return true;
        } else if (!nextField.isAvailable() || !(nextField.getChecker() == null)) {
            return false;
        } else {
            List<Move> moves = checker.getMoveSet().getMoves();
            for (Move move: moves) {
                if (move.getClass().equals(MoveOneSquare.class)) {
                    if(validateForMoveOneSquare(x1, y1, x2, y2))
                        return true;
                } else if (move.getClass().equals(MoveJump.class)) {
                  MoveJump moveJump = (MoveJump) move;
                     if (moveJump.validateMove(x1, y1, x2, y2, board)) {
                         return true;
                     }
                }
            }
        }
        return false;
    }

    /**
     * Method which validates move for 'move one square'.
     * @param x1 current field row
     * @param y1 current field column
     * @param x2 next field row
     * @param y2 next field column
     * @return true if move is possible, otherwise false
     */
    private boolean validateForMoveOneSquare(int x1, int y1, int x2, int y2) {
        if ((Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 1) || (Math.abs(y1 - y2) == 2 && x1 - x2 == 0)) {
            return true;
        }
        return false;
    }

    /**
     * Method which validates move for 'move jump'.
     * @param x1 current field row
     * @param y1 current field column
     * @param x2 next field row
     * @param y2 next field column
     * @param tempx temporary field row
     * @param tempy temporary field column
     * @param board up-to-date board
     * @return true if move is valid, otherwise false
     */
    private boolean validateForMoveJump(int x1, int y1, int x2, int y2, int tempx, int tempy, Board board) {
      Integer offsetX[] = { -1, -1, 1, 1 };
      Integer offsetY[] = { -1, 1, 1, -1 };
        Field[] fieldsAround = new Field[6]; // it the beginning tempx and tempy equal to x1, y1
        for (int i = 0; i < 6; i++) {
            if (!(tempx + valx[i] == x1 && tempy + valy[i] == y1)
                    && tempx + valx[i] >= 0 && tempx + valx[i] < board.getRows()
                    && tempy + valy[i] >= 0 && tempy + valy[i] < board.getCols()) {
                fieldsAround[i] = board.getField(tempx + valx[i], tempy + valy[i]);
            } else {
                fieldsAround[i] = null;
            }
        }
        visited.add(board.getField(x1, y1));
        for (int i = 0; i < 6; i++) {
            if (fieldsAround[i] != null && fieldsAround[i].getX() == x2 && fieldsAround[i].getY() == y2) {
                return true;
            }
            if (fieldsAround[i] != null && fieldsAround[i].getChecker() != null && !isVisited(fieldsAround[i], visited)
                    && ifNeighboursAreEmpty(fieldsAround[i], board)) { // the closest neighbour has checker, can proceed
                visited.add(fieldsAround[i]);
                return validateForMoveJump(tempx, tempy, x2, y2, fieldsAround[i].getX(), fieldsAround[i].getY(), board);
            }

        }
        for (int i = 0; i < 6; i++) {
                int idx = checkNeighbourNeighbours(fieldsAround, board);
                if (idx != -1 && !isVisited(fieldsAround[idx], visited)) {
                    visited.add(fieldsAround[idx]);
                    return validateForMoveJump(tempx, tempy, x2, y2, fieldsAround[idx].getX(), fieldsAround[idx].getY(), board);
                }
        }
        return false;
    }

    /**
     * Method to check paths with neighbour's neighbours.
     * @param neighbours neighbours of neighbour
     * @param board up-to-date board
     * @return index of neighbour which lead to right path
     */
    private int checkNeighbourNeighbours(Field[] neighbours, Board board) {
        for (int i = 0; i < 6; i++) {
            if (neighbours[i] != null) {
                int row = neighbours[i].getX();
                int col = neighbours[i].getY();
                Field temp;
                // check if neighbours of this neighbour have checkers
                for (int j = 0; j < 6; j++) {
                    if (row + valx[j] >= 0 && row + valx[j] < board.getRows() && col + valy[j] >= 0 && col + valy[j] < board.getCols()) {
                        temp = board.getField(row + valx[j], col + valy[j]);
                        if (temp != null && temp.getChecker() != null && !isVisited(temp, visited)) {
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Method which checks if neighbours of field are empty.
     * @param field field which neighbours method checks
     * @param board up-to-date board
     * @return true if at least one neighbour is empty, if all have checkers method return false
     */
    private boolean ifNeighboursAreEmpty(Field field, Board board) {
        int row = field.getX();
        int col = field.getY();
        for (int i = 0; i < 6; i++) {
            // check if there exists neighbour without checkers
            Field temp;
            if (row + valx[i] >= 0 && row + valx[i] < board.getRows() && col + valy[i] >= 0 && col + valy[i] < board.getCols()) {
                temp = board.getField(row + valx[i], col + valy[i]);
                if (temp != null && temp.getChecker() == null && !isVisited(temp, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method which checks if field was visited.
     * @param field field to check
     * @param fields list of fields which were visited
     * @return true if field was visited, false if it wasn't
     */
    private boolean isVisited(Field field, List<Field> fields) {
        for (Field toCheck : fields) {
            if (toCheck.equals(field)) {
                return true;
            }
        }
        return false;
    }
}
