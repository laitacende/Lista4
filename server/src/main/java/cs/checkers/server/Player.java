package cs.checkers.server;

import cs.checkers.gamelogic.board.Board;
import cs.checkers.gamelogic.board.Corner;
import cs.checkers.gamelogic.checker.Checker;
import cs.checkers.gamelogic.field.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which represents player.
 */
public class Player {
    /**
     * Lis of player's checkers.
     * @see cs.checkers.gamelogic.checker.Checker
     */
    private List<Checker> ownCheckers = new ArrayList<>();

    /**
     * Player's starting corner.
     */
    private Corner corner;

    /**
     * Main constructor.
     * @param corner player's starting corner
     */
    public Player(Corner corner) {
        this.corner = corner;
        addCheckers();
    }

    /**
     * Method which adds checkers to player from their starting corner.
     */
    private void addCheckers() {
        List<Field> fields = corner.getFields();
        for (Field field: fields) {
            if (field.isAvailable()) {
                ownCheckers.add(field.getChecker()); // not null, in the begging all checkers are in corner
            }
        }
    }

    /**
     * Method which checks if all of the player's checkers are in the opposite corner ('home').
     * @return true if all checkers are in 'home' (opposite corner)
     */
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

    /**
     * Method which checks if particular checker belongs to player.
     * @param checker checker to check
     * @return true if checker belongs to player, otherwise false
     */
    public boolean hasChecker(Checker checker) {
        for(Checker ownChecker: ownCheckers) {
            if (checker.equals(ownChecker)) {
                return true;
            }
        }
        return false;
    }
}
