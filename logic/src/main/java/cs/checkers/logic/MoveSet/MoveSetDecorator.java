package cs.checkers.logic.MoveSet;

import cs.checkers.logic.Field.Field;
import cs.checkers.logic.Move.Move;

import java.util.List;

public abstract class MoveSetDecorator extends AbstractMoveSet {
    protected final AbstractMoveSet moveSet;

    public MoveSetDecorator(AbstractMoveSet moveSet) {
        this.moveSet = moveSet;
    }

    public void addMove(){};

    // irrelevant
    @Override
    public List<String> getAvailableMoves(Field field) {
        return null;
    }


    @Override
    public void addMoveToList(Move move) {
        moveSet.addMoveToList(move);
    }

    @Override
    public List<Move> getMoves() {
        return moveSet.getMoves();
    }
}
