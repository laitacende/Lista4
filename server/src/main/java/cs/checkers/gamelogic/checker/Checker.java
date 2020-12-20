package cs.checkers.gamelogic.checker;

import cs.checkers.gamelogic.moveset.MoveSet;

/**
 * Class that represents checker.
 */
public abstract class Checker {
    /**
     * Checker's move set.
     * @see cs.checkers.gamelogic.moveset.MoveSet
     */
    protected MoveSet moveSet;

    /**
     * Getter for moveSet.
     * @return checker's move set
     */
    public MoveSet getMoveSet() {
        return this.moveSet;
    }

    /**
     * Setter for move set.
     * @param moveSet move set to be set
     */
    public void setMoveSet(MoveSet moveSet) {
        this.moveSet = moveSet;
    }
}
