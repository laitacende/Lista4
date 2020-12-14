package cs.checkers.logic.moveset;

import cs.checkers.logic.field.Field;
import cs.checkers.logic.move.Move;

import java.util.List;

public abstract class AbstractMoveSet {
    protected List<Move> moves;

    public void addMoveToList(Move move) {
        moves.add(move);
    }

    public List<Move> getMoves() {
        return moves;
    }
    
}
