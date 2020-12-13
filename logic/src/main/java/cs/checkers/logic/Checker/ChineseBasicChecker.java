package cs.checkers.logic.Checker;

import cs.checkers.logic.MoveSet.MoveSet;

public class ChineseBasicChecker extends Checker {

    @Override
    public MoveSet getMoveSet() {
        return this.moveSet;
    }

    @Override
    public void setMoveSet(MoveSet moveSet) {
        this.moveSet = moveSet;
    }
}
