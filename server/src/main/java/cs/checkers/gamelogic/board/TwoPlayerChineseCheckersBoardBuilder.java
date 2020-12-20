package cs.checkers.gamelogic.board;

/**
 * Concrete builder of {@link ChineseCheckersBoardBuilder ChineseCheckersBoardBuilder}.
 */
public class TwoPlayerChineseCheckersBoardBuilder extends ChineseCheckersBoardBuilder {
    /**
     * Method which adds fields to corners and sets opposite corners.
     */
    protected void addCorners() {
        Corner cornerPlayer1 = new Corner();
        Corner cornerPlayer2 = new Corner();

        // add fields to corners
        // 'upper' corner
        for (int i = 0; i < 4; i++) {
            for (int j = 9; j < 16; j++) {
                if (board.getField(i, j).isAvailable()) { // plain field
                    cornerPlayer1.addField(board.getField(i, j));
                    // put checkers
                    board.getField(i, j).putChecker(builderChecker.buildChecker());
                }
            }
        }

        // 'lower' corner
        for (int i = 13; i < 17; i++) {
            for (int j = 9; j < 16; j++) {
                if (board.getField(i, j).isAvailable()) { // plain field
                    cornerPlayer2.addField(board.getField(i, j));
                    board.getField(i, j).putChecker(builderChecker.buildChecker());
                }
            }
        }
        cornerPlayer1.setOppositeCorner(cornerPlayer2);
        cornerPlayer2.setOppositeCorner(cornerPlayer1);

        board.addCorner(cornerPlayer1);
        board.addCorner(cornerPlayer2);
    }
}
