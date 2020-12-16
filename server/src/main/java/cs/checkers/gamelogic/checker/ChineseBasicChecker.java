package cs.checkers.gamelogic.checker;

import cs.checkers.gamelogic.moveset.MoveSet;

/**
 * Class which represents default checker for Chinese checkers game.
 */
public class ChineseBasicChecker extends Checker {

    /**
     * Move set getter.
     * @return move set of checker
     */
    @Override
    public MoveSet getMoveSet() {
        return this.moveSet;
    }

    /**
     * Setter for move set.
     * @param moveSet move set to be set
     */
    @Override
    public void setMoveSet(MoveSet moveSet) {
        this.moveSet = moveSet;
    }
}
