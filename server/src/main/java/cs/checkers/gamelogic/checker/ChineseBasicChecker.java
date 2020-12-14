package cs.checkers.gamelogic.checker;

import cs.checkers.gamelogic.moveset.MoveSet;

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
