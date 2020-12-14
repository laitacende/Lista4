package cs.checkers.gamelogic.movevalidator;

import cs.checkers.gamelogic.board.Board;
import cs.checkers.gamelogic.checker.Checker;
import cs.checkers.gamelogic.field.Field;
import cs.checkers.gamelogic.field.UnavailableField;
import cs.checkers.gamelogic.move.Move;
import cs.checkers.gamelogic.move.MoveJump;
import cs.checkers.gamelogic.move.MoveOneSquare;

import java.util.List;

public class MoveValidator {
    public boolean validateMove(String command, Board board) { // command in format 'move x_1,y_1 x_2,y_2'
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
                     if (validateForMoveJump(x1, y1, x2, y2, board)) {
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

    private boolean validateForMoveJump(int x1, int y1, int x2, int y2, Board board) {

        // return false if there are no checkers around field
        if (true) {
            return false;
        }
        return false;
    }
}
