package cs.checkers.gamelogic.board;

public abstract class BoardBuilder {

    protected Board board = Board.getInstance();

    public abstract Board getBoard();

    protected abstract void addCorners();
}
