package cs.checkers.logic.checker;

import cs.checkers.logic.moveset.MoveSet;

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
