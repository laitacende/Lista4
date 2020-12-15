package cs.checkers.gamelogic.movevalidator;

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

public class MoveValidator {
    private ArrayList<Field> visited = new ArrayList<>();
    private final Integer[] valx = {-1, 0, 1, 1, 0, -1};
    private final Integer[] valy = {1, 2, 1, -1, -2, -1};

    public boolean validateMove(String command, Board board) { // command in format 'move x_1,y_1 x_2,y_2'
        visited.clear();
        String[] args = splitCommand(command, " "); // coordinates at 1, 2
        String[] coordinatesPrev = splitCommand(args[1], ",");
        String[] coordinatesNext = splitCommand(args[2], ",");
        int x1 = Integer.parseInt(coordinatesPrev[0]);
        int y1 = Integer.parseInt(coordinatesPrev[1]);
        int x2 = Integer.parseInt(coordinatesNext[0]);
        int y2 = Integer.parseInt(coordinatesNext[1]);

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
                     if (validateForMoveJump(x1, y1, x2, y2, x1, y1, board)) {
                         return true;
                     }
                }
            }
        }
        return false;
    }

    private String[] splitCommand(String command, String separator) {
        String[] result = command.split(separator);
        return result;
    }

    private boolean validateForMoveOneSquare(int x1, int y1, int x2, int y2) {
        if ((Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 1) || (Math.abs(y1 - y2) == 2 && x1 - x2 == 0)) {
            return true;
        }
        return false;
    }

    private boolean validateForMoveJump(int x1, int y1, int x2, int y2, int tempx, int tempy, Board board) {
        Field[] fieldsAround = new Field[6]; // it the beginning tempx and tempy equal to x1, y1
        for (int i = 0; i < 6; i++) {
            if (!(tempx + valx[i] == x1 && tempy + valy[i] == y1)) {
                fieldsAround[i] = board.getField(tempx + valx[i], tempy + valy[i]);
            } else {
                fieldsAround[i] = null;
            }
        }
        //System.out.println("ogolnie" + tempx + "'" + tempy);
        visited.add(board.getField(x1, y1));
        for (int i = 0; i < 6; i++) {
            if (fieldsAround[i] != null && fieldsAround[i].getX() == x2 && fieldsAround[i].getY() == y2) {
                return true;
            }
            if (fieldsAround[i] != null && fieldsAround[i].getChecker() != null && !isVisited(fieldsAround[i], visited)
                    && ifNeighboursAreEmpty(fieldsAround[i], board)) { // the closest neighbour has checker, can proceed
                visited.add(fieldsAround[i]);
               // System.out.println("w najblizszych");
                return validateForMoveJump(tempx, tempy, x2, y2, fieldsAround[i].getX(), fieldsAround[i].getY(), board);
            }

        }
        for (int i = 0; i < 6; i++) {
                int idx = checkNeighbourNeighbours(tempx, tempy, x2, y2, fieldsAround, board, visited);
                if (idx != -1 && !isVisited(fieldsAround[idx], visited)) {
                   // System.out.println("w dalsych");
                    visited.add(fieldsAround[idx]);
                    return validateForMoveJump(tempx, tempy, x2, y2, fieldsAround[idx].getX(), fieldsAround[idx].getY(), board);
                }
        }
        return false;
    }

    public int checkNeighbourNeighbours(int oldRow, int oldCol, int destx, int desty, Field[] neighbours, Board board, List<Field> visited) {
        for (int i = 0; i < 6; i++) {
            if (neighbours[i] != null) {
                int row = neighbours[i].getX();
                int col = neighbours[i].getY();
                Field temp;
                // check if neighbours of this neighbour have checkers
                for (int j = 0; j < 6; j++) {
                    temp = board.getField(row + valx[j], col + valy[j]);
                    if (temp != null && temp.getChecker() != null && !isVisited(temp, visited)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    private boolean ifNeighboursAreEmpty(Field field, Board board) {
        for (int i = 0; i < 6; i++) {
            // check if there exists neighbour without checkers
            Field temp;
            temp = board.getField(field.getX() + valx[i], field.getY() + valy[i]);
            if (temp != null && temp.getChecker() == null && !isVisited(temp, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean isVisited(Field field, List<Field> fields) {
        for (Field toCheck : fields) {
            if (toCheck.equals(field)) {
                return true;
            }
        }
        return false;
    }
}
