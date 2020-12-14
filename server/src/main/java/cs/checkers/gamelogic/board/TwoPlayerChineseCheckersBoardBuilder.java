package cs.checkers.gamelogic.board;

import cs.checkers.gamelogic.field.PlainField;

public class TwoPlayerChineseCheckersBoardBuilder extends ChineseCheckersBoardBuilder {

    protected void addCorners() {
        Corner cornerPlayer1 = new Corner();
        Corner cornerPlayer2 = new Corner();

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
                    cornerPlayer2.addField(board.getField(i, j));
                }
            }
        }
        cornerPlayer1.setOppositeCorner(cornerPlayer2);
        cornerPlayer2.setOppositeCorner(cornerPlayer1);

        board.addCorner(cornerPlayer1);
        board.addCorner(cornerPlayer2);
    }
}
