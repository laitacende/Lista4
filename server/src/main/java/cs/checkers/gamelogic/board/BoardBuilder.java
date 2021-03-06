package cs.checkers.gamelogic.board;

import cs.checkers.gamelogic.checker.BuilderChecker;

/**
 * Builder for objects of class {@link Board Board}.
 */
public abstract class BoardBuilder {
    /**
     * Builder for checkers.
     */
    protected BuilderChecker builderChecker;
    /**
     * Default number of board's rows.
     */
    protected int rows = 17;

    /**
     * Default number of board's columns.
     */
    protected int cols = 25;

    /**
     * Instance of board.
     */
    protected Board board = Board.getInstance();

    /**
     * Method which return built board of class {@link Board Board}
     * @return built board.
     */
    public abstract Board getBoard();

    /**
     * Method to add corners to board.
     */
    protected abstract void addCorners();

}
