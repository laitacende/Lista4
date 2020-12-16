package cs.checkers.gamelogic.checker;

import cs.checkers.gamelogic.move.MoveJump;
import cs.checkers.gamelogic.move.MoveOneSquare;
import cs.checkers.gamelogic.moveset.MoveSet;

/**
 * Builder for default checker for Chinese checkers.
 * @see cs.checkers.gamelogic.checker.ChineseBasicChecker
 */
public class ChineseBasicCheckerBuilder extends BuilderChecker {
    /**
     * Method which creates checker and sets attributes.
     * @return built checker
     */
    @Override
    public Checker buildChecker() {
        Checker checker = new ChineseBasicChecker();
        MoveSet moveSet = new MoveSet();
        moveSet.addMoveToList(new MoveOneSquare());
        moveSet.addMoveToList(new MoveJump());
        checker.setMoveSet(moveSet);
        return checker;
    }
}
