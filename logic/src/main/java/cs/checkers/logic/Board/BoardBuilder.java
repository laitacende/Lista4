package cs.checkers.logic.Board;

/*
Builder class for class {@link boardGame.Board.boardGame.Board boardGame.Board.boardGame.Board}.
 */
public abstract class BoardBuilder {
    /**
     * Instance of class {@link Board boardGame.Board.boardGame.Board}.
     */
    protected Board board = Board.getInstance();

    /**
     * Method to get built board.
     * @return object of class {@link Board boardGame.Board.boardGame.Board}.
     */
    public abstract Board getBoard();

    /**
     * Add objects of class {@link Corner boardGame.Board.Corner} to list in boardGame.Board.boardGame.Board.
     */
    protected abstract void addCorners();
}
