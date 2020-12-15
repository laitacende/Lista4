package cs.checkers.gamelogic.board;

public abstract class BoardBuilder {
    protected int rows = 17;
    protected int cols = 25;
    protected Board board = Board.getInstance();

    public abstract Board getBoard();

    protected abstract void addCorners();
}
