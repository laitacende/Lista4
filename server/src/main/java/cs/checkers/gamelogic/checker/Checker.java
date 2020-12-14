package cs.checkers.gamelogic.checker;

import cs.checkers.gamelogic.moveset.MoveSet;

public abstract class Checker {
    protected MoveSet moveSet;

    public abstract MoveSet getMoveSet();

    public abstract void setMoveSet(MoveSet moveSet);
}
