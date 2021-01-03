package cs.checkers.gamelogic.board;

import cs.checkers.gamelogic.checker.BuilderChecker;
import cs.checkers.gamelogic.checker.ChineseBasicCheckerBuilder;

/**
 * Builder for board to play chinese checkers.
 * @see cs.checkers.gamelogic.board.Board
 */
public abstract class ChineseCheckersBoardBuilder extends BoardBuilder {
    /**
     * Builder for checkers.
     */
    protected BuilderChecker builderChecker = new ChineseBasicCheckerBuilder();
    /**
     * Array with number of unavailable fields in particular row.
     */
    private final int[] unavailable = {12, 11, 10, 9, 0, 1, 2, 3, 4, 3, 2, 1, 0, 9, 10, 11, 12};

    /**
     * Method which builds board - sets size and types of fields.
     * @return built board
     */
    @Override
    public Board getBoard() {
        board.initializeFields(rows, cols);
        board.setRowsAndCols(rows, cols);
        // set up basic fields - available and unavailable
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) { // set unavailable fields
                if (cols - j < unavailable[i] || j < unavailable[i]) {
                    board.setFieldType(i, j, "unavailable");
                } else {
                    if (j % 2 == i % 2) {
                        board.setFieldType(i, j, "plain");
                    } else {
                        board.setFieldType(i, j, "unavailable");
                    }
                }
            }
        }
        addCorners();
        return board;
    }
}
