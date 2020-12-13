package cs.checkers.logic.Checker;

import cs.checkers.logic.MoveSet.MoveSet;

public abstract class Checker {
    protected MoveSet moveSet;

    public abstract MoveSet getMoveSet();

    public abstract void setMoveSet(MoveSet moveSet);
}
