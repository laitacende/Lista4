package cs.checkers.gamelogic.moveset;

import cs.checkers.gamelogic.move.Move;

import java.util.List;

/**
 * Class which represents moves that checker can perform.
 */
public abstract class AbstractMoveSet {
    /**
     * List of permitted moves.
     */
    protected List<Move> moves;

    /**
     * Method to add new moves to list.
     * @param move move to be added
     */
    public void addMoveToList(Move move) {
        moves.add(move);
    }

    /**
     * Method to get list of allowed moves.
     * @return list of moves
     */
    public List<Move> getMoves() {
        return moves;
    }
    
}
