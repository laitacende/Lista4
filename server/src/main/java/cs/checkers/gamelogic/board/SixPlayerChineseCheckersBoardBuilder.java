package cs.checkers.gamelogic.board;

/**
 * Concrete builder of {@link ChineseCheckersBoardBuilder ChineseCheckersBoardBuilder}.
 */
public class SixPlayerChineseCheckersBoardBuilder extends ChineseCheckersBoardBuilder {
    /**
     * Method which adds fields to corners and sets opposite corners.
     */
    protected void addCorners() {
        Corner cornerPlayer1 = new Corner();
        Corner cornerPlayer4 = new Corner();

        for (int i = 0; i < 4; i++) {
            for (int j = 9; j < 16; j++) {
                if (board.getField(i, j).isAvailable()) { // plain field
                    cornerPlayer1.addField(board.getField(i, j));
                    board.getField(i, j).putChecker(builderChecker.buildChecker());
                }
            }
        }

        for (int i = 13; i < 17; i++) {
            for (int j = 9; j < 16; j++) {
                if (board.getField(i, j).isAvailable()) { // plain field
                    cornerPlayer4.addField(board.getField(i, j));
                    board.getField(i, j).putChecker(builderChecker.buildChecker());
                }
            }
        }

        cornerPlayer1.setOppositeCorner(cornerPlayer4);
        cornerPlayer4.setOppositeCorner(cornerPlayer1);

        Corner cornerPlayer2 = new Corner();
        Corner cornerPlayer5 = new Corner();

        for (int i = 4; i < 8; i++) {
            for (int j = 18; j < 25; j++) {
                if (board.getField(i, j).isAvailable()) { // plain field
                    cornerPlayer2.addField(board.getField(i, j));
                    board.getField(i, j).putChecker(builderChecker.buildChecker());
                }
            }
        }

        for (int i = 9; i < 13; i++) {
            for (int j = 0; j < 7; j++) {
                if (board.getField(i, j).isAvailable()) { // plain field
                    cornerPlayer5.addField(board.getField(i, j));
                    board.getField(i, j).putChecker(builderChecker.buildChecker());
                }
            }
        }
        cornerPlayer2.setOppositeCorner(cornerPlayer5);
        cornerPlayer5.setOppositeCorner(cornerPlayer2);

        Corner cornerPlayer3 = new Corner();
        Corner cornerPlayer6 = new Corner();

        for (int i = 9; i < 13; i++) {
            for (int j = 18; j < 25; j++) {
                if (board.getField(i, j).isAvailable()) { // plain field
                    cornerPlayer3.addField(board.getField(i, j));
                    board.getField(i, j).putChecker(builderChecker.buildChecker());
                }
            }
        }

        for (int i = 4; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if (board.getField(i, j).isAvailable()) { // plain field
                    cornerPlayer6.addField(board.getField(i, j));
                    board.getField(i, j).putChecker(builderChecker.buildChecker());
                }
            }
        }
        cornerPlayer3.setOppositeCorner(cornerPlayer6);
        cornerPlayer6.setOppositeCorner(cornerPlayer3);

        board.addCorner(cornerPlayer1);
        board.addCorner(cornerPlayer2);
        board.addCorner(cornerPlayer3);
        board.addCorner(cornerPlayer4);
        board.addCorner(cornerPlayer5);
        board.addCorner(cornerPlayer6);
    }
}
