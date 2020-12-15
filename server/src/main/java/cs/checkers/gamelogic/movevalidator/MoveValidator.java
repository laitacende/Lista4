package cs.checkers.gamelogic.movevalidator;

import cs.checkers.gamelogic.board.Board;
import cs.checkers.gamelogic.checker.Checker;
import cs.checkers.gamelogic.checker.ChineseBasicChecker;
import cs.checkers.gamelogic.field.Field;
import cs.checkers.gamelogic.field.UnavailableField;
import cs.checkers.gamelogic.move.Move;
import cs.checkers.gamelogic.move.MoveJump;
import cs.checkers.gamelogic.move.MoveOneSquare;

import java.util.List;

public class MoveValidator {
    private Board board;

    public boolean validateMove(String command, Board board) { // command in format 'move x_1,y_1 x_2,y_2'
        this.board = board;
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

        if (nextField instanceof UnavailableField || !(nextField.getChecker() == null)) {
            return false;
        } else {
            List<Move> moves = checker.getMoveSet().getMoves();
            for (Move move: moves) {
                if (move instanceof MoveOneSquare) {
                    if(validateForMoveOneSquare(x1, y1, x2, y2))
                        return true;
                } else if (move instanceof MoveJump) {
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
        System.out.println(tempx + "temprary first" + tempy);
        if (!(tempx - 1  == x1 && tempy + 1 == y1)) {
            fieldsAround[0] = board.getField(tempx - 1, tempy + 1);
        } else {
            fieldsAround[0] = null;
        }
        if (!(tempx == x1 && tempy + 2 == y1)) {
            fieldsAround[1] = board.getField(tempx, tempy + 2);
        } else {
            fieldsAround[1] = null;
        }
        if (!(tempx + 1  == x1 && tempy + 1 == y1)) {
            fieldsAround[2] = board.getField(tempx + 1, tempy + 1);
        } else {
            fieldsAround[2] = null;
        }
        if (!(tempx + 1  == x1 && tempy - 1 == y1)) {
            fieldsAround[3] = board.getField(tempx + 1, tempy - 1);
        } else {
            fieldsAround[3] = null;
        }
        if (!(tempx == x1 && tempy - 2 == y1)) {
            fieldsAround[4] = board.getField(tempx, tempy - 2);
        } else {
            fieldsAround[4] = null;
        }
        if (!(tempx - 1  == x1 && tempy - 1 == y1)) {
            fieldsAround[5] = board.getField(tempx - 1, tempy - 1);
        } else {
            fieldsAround[5] = null;
        }
        System.out.println(tempx + ",temp" + tempy);
        if (tempx == x2 && tempy == y2) {
            return true;
        }
        for (int i = 0; i < 6; i++) {
            if (fieldsAround[i] != null && fieldsAround[i].getX() == x2 && fieldsAround[i].getY() == y2) {
                return true;
            }
                if (fieldsAround[i] != null && fieldsAround[i].getChecker() != null) { // the closest neighbour has checker, can preceed
                    // System.out.println(fieldsAround[i].getX() + "," + fieldsAround[i].getY());
                    return validateForMoveJump(x1, y1, x2, y2, fieldsAround[i].getX(), fieldsAround[i].getY(), board);
                } else {
                    int idx = checkNeighbourNeighbours(tempx, tempy, x2, y2, fieldsAround, board);
                    System.out.println("check" + idx);
                    if (idx != -1) {
                        return validateForMoveJump(x1, y1, x2, y2, fieldsAround[idx].getX(), fieldsAround[idx].getY(), board);
                    } else {
                        return false;
                    }
                }
            }
        return false;
    }

    public int checkNeighbourNeighbours(int oldRow, int oldCol, int destx, int desty, Field[] neighbours, Board board) {
        for (int i = 0; i < 6; i++) {
            if (neighbours[i] != null) {
                int row = neighbours[i].getX();
                int col = neighbours[i].getY();
                Field temp;
                Integer[] valx = {-1, 0, 1, 1, 0, -1 };
                Integer[] valy = {1, 2, 1, -1, -2, -1 };
                // check if neighbours of this neighbour have checkers
                for (int j = 0; j < 6; j++) {
                    temp = board.getField(row + valx[j], col + valy[j]);
                    double distanceOld = Math.sqrt((oldRow - destx) * (oldRow - destx) + (oldCol - desty) * (oldCol - desty));
                    double distanceNew = Math.sqrt((temp.getX() - destx) * (temp.getX() - destx) + (temp.getY() - desty) * (temp.getY() - desty));
                    if (temp != null && temp.getChecker() != null && distanceOld > distanceNew) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
