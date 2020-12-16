package cs.checkers.gamelogic.board;

import cs.checkers.common.BoardTypes;

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
    public Board getBoard(BoardTypes type) {
        if (type.equals(BoardTypes.TwoPlayerChineseCheckers)) {
            builder = new TwoPlayerChineseCheckersBoardBuilder();
            return builder.getBoard();
        } else if (type.equals(BoardTypes.ThreePlayerChineseCheckers)) {
            builder = new ThreePlayerChineseCheckersBoardBuilder();
            return builder.getBoard();
        } else if (type.equals(BoardTypes.FourPlayerChineseCheckers)) {
            builder = new FourPlayerChineseCheckersBoardBuilder();
            return builder.getBoard();
        } else if (type.equals(BoardTypes.SixPlayerChineseCheckers)) {
            builder = new SixPlayerChineseCheckersBoardBuilder();
            return builder.getBoard();
        }
        return null;
    }
}
