package cs.checkers.gamelogic.moveset;

import cs.checkers.gamelogic.move.Move;

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
