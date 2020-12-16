package cs.checkers.gamelogic.board;

/**
 * Director for {@link BoardBuilder BoardBuilder}.
 */
public class BoardFactory {
    /**
     * {@link BoardBuilder BoardBuilder} builder for board.
     */
    BoardBuilder builder;

    /**
     * Method that creates board based on type.
     * @param type type of board to be created
     * @return built board
     */
    public Board getBoard(String type) {
        if (type.equals("2PlayerChineseCheckersBoard")) {
            builder = new TwoPlayerChineseCheckersBoardBuilder();
            return builder.getBoard();
        } else if (type.equals("3PlayerChineseCheckersBoard")) {
            builder = new ThreePlayerChineseCheckersBoardBuilder();
            return builder.getBoard();
        } else if (type.equals("4PlayerChineseCheckersBoard")) {
            builder = new FourPlayerChineseCheckersBoardBuilder();
            return builder.getBoard();
        } else if (type.equals("6PlayerChineseCheckersBoard")) {
            builder = new SixPlayerChineseCheckersBoardBuilder();
            return builder.getBoard();
        }
        return null;
    }
}
