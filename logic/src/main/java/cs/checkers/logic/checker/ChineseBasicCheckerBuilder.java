package cs.checkers.logic.checker;

import cs.checkers.logic.move.MoveJump;
import cs.checkers.logic.move.MoveOneSquare;
import cs.checkers.logic.moveset.MoveSet;

public class ChineseBasicCheckerBuilder extends BuilderChecker {
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
