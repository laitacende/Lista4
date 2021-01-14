package cs.checkers.gamelogic.board;


/**
 * Concrete builder of {@link ChineseCheckersBoardBuilder ChineseCheckersBoardBuilder}.
 */
public class FourPlayerChineseCheckersBoardBuilder extends ChineseCheckersBoardBuilder {
    /**
     * Method which adds fields to corners and sets opposite corners.
     */
    protected void addCorners() {
        int offset[] = {3, 2, 1, 0};
        Corner cornerPlayer1 = new Corner();
        Corner cornerPlayer3 = new Corner();

        for (int i = 4; i < 8; i++) {
            for (int j = 18 + offset[7 - i]; j < 25; j++) {
                if (board.getField(i, j).isAvailable()) { // plain field
                    cornerPlayer1.addField(board.getField(i, j));
                    board.getField(i, j).putChecker(builderChecker.buildChecker());
                }
            }
        }

        for (int i = 9; i < 13; i++) {
            for (int j = 0; j < 7 - offset[i - 9]; j++) {
                if (board.getField(i, j).isAvailable()) { // plain field
                    cornerPlayer3.addField(board.getField(i, j));
                    board.getField(i, j).putChecker(builderChecker.buildChecker());
                }
            }
        }

        cornerPlayer1.setOppositeCorner(cornerPlayer3);
        cornerPlayer3.setOppositeCorner(cornerPlayer1);

        Corner cornerPlayer2 = new Corner();
        Corner cornerPlayer4 = new Corner();

        for (int i = 9; i < 13; i++) {
            for (int j = 18 + offset[i - 9]; j < 25; j++) {
                if (board.getField(i, j).isAvailable()) { // plain field
                    cornerPlayer2.addField(board.getField(i, j));
                    board.getField(i, j).putChecker(builderChecker.buildChecker());
                }
            }
        }

        for (int i = 4; i < 8; i++) {
            for (int j = 0; j < 7 - offset[7 - i]; j++) {
                if (board.getField(i, j).isAvailable()) { // plain field
                    cornerPlayer4.addField(board.getField(i, j));
                    board.getField(i, j).putChecker(builderChecker.buildChecker());
                }
            }
        }
        cornerPlayer2.setOppositeCorner(cornerPlayer4);
        cornerPlayer4.setOppositeCorner(cornerPlayer2);

        board.addCorner(cornerPlayer1);
        board.addCorner(cornerPlayer2);
        board.addCorner(cornerPlayer3);
        board.addCorner(cornerPlayer4);
    }
}
