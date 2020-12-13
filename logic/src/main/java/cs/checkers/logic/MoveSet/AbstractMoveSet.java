package cs.checkers.logic.MoveSet;

import cs.checkers.logic.Field.Field;
import cs.checkers.logic.Move.Move;

import java.util.List;

public abstract class AbstractMoveSet {
    protected List<Move> moves;

    public abstract List<String> getAvailableMoves(Field field);

    public void addMoveToList(Move move) {
        moves.add(move);
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void addMove() {}

}
