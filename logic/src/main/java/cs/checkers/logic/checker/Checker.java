package cs.checkers.logic.checker;

import cs.checkers.logic.moveset.MoveSet;

public abstract class Checker {
    protected MoveSet moveSet;

    public abstract MoveSet getMoveSet();

    public abstract void setMoveSet(MoveSet moveSet);
}
