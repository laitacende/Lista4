package cs.checkers.gamelogic.checker;

import cs.checkers.gamelogic.move.MoveJump;
import cs.checkers.gamelogic.move.MoveOneSquare;
import cs.checkers.gamelogic.moveset.MoveSet;

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
