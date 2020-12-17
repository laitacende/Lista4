package cs.checkers.gamelogic.board;

import cs.checkers.gamelogic.field.PlainField;

/**
 * Concrete builder of {@link ChineseCheckersBoardBuilder ChineseCheckersBoardBuilder}.
 */
public class ThreePlayerChineseCheckersBoardBuilder extends ChineseCheckersBoardBuilder {
    /**
     * Method which adds fields to corners and sets opposite corners.
     */
    protected void addCorners() {
        Corner cornerPlayer1 = new Corner();
        Corner oppositeCornerPlayer1 = new Corner();

        // add fields to corners
        // 'upper' corner
        for (int i = 0; i < 4; i++) {
            for (int j = 9; j < 16; j++) {
                if (board.getField(i, j) instanceof PlainField) { // plain field
                    cornerPlayer1.addField(board.getField(i, j));
                }
            }
        }

        // 'lower' corner
        for (int i = 13; i < 17; i++) {
            for (int j = 9; j < 16; j++) {
                if (board.getField(i, j) instanceof PlainField) { // plain field
                    oppositeCornerPlayer1.addField(board.getField(i, j));
                }
            }
        }

        cornerPlayer1.setOppositeCorner(oppositeCornerPlayer1);

        Corner cornerPlayer2 = new Corner();
        Corner oppositeCornerPlayer2 = new Corner();

        for (int i = 9; i < 13; i++) {
            for (int j = 18; j < 25; j++) {
                if (board.getField(i, j) instanceof PlainField) { // plain field
                    cornerPlayer2.addField(board.getField(i, j));
                }
            }
        }

        for (int i = 4; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if (board.getField(i, j) instanceof PlainField) { // plain field
                    oppositeCornerPlayer2.addField(board.getField(i, j));
                }
            }
        }
        cornerPlayer2.setOppositeCorner(oppositeCornerPlayer2);

        Corner cornerPlayer3 = new Corner();
        Corner oppositeCornerPlayer3 = new Corner();

        for (int i = 9; i < 13; i++) {
            for (int j = 0; j < 7; j++) {
                if (board.getField(i, j) instanceof PlainField) { // plain field
                    cornerPlayer3.addField(board.getField(i, j));
                }
            }
        }

        for (int i = 4; i < 8; i++) {
            for (int j = 18; j < 25; j++) {
                if (board.getField(i, j) instanceof PlainField) { // plain field
                    oppositeCornerPlayer3.addField(board.getField(i, j));
                }
            }
        }
        cornerPlayer3.setOppositeCorner(oppositeCornerPlayer3);

        board.addCorner(cornerPlayer1);
        board.addCorner(cornerPlayer2);
        board.addCorner(cornerPlayer3);
       // board.addCorner(oppositeCornerPlayer1);
       // board.addCorner(oppositeCornerPlayer2);
       // board.addCorner(oppositeCornerPlayer3);
    }
}
