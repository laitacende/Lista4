package cs.checkers.server;

import cs.checkers.gamelogic.board.Board;
import cs.checkers.gamelogic.board.Corner;
import cs.checkers.gamelogic.checker.Checker;
import cs.checkers.gamelogic.field.Field;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Checker> ownCheckers = new ArrayList<>();
    private Corner corner;

    public Player(Corner corner) {
        this.corner = corner;
        addCheckers();
    }

    private void addCheckers() {
        List<Field> fields = corner.getFields();
        for (Field field: fields) {
            if (field.isAvailable()) {
                ownCheckers.add(field.getChecker()); // not null, in the begging all checkers are in corner
            }
        }
    }

    public boolean checkIfFinished() {
        Corner opposite = corner.getOppositeCorner();
        List<Field> oppositeFields = opposite.getFields();
        int numberOfCheckers = ownCheckers.size();
        // check if all of the player's checkers are in the opposite corner
        for (Field field: oppositeFields) {
            for (Checker checker: ownCheckers) {
                if (field.getChecker() != null && field.getChecker().equals(checker)) {
                    numberOfCheckers--;
                }
            }
        }
        return numberOfCheckers == 0;
    }

    public boolean hasChecker(Checker checker) {
        for(Checker ownChecker: ownCheckers) {
            if (checker.equals(ownChecker)) {
                return true;
            }
        }
        return false;
    }
}
