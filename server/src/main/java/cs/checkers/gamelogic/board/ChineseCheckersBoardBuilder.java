package cs.checkers.gamelogic.board;

public abstract class ChineseCheckersBoardBuilder extends BoardBuilder {
    private final int[] unavailable = {12, 11, 10, 9, 0, 1, 2, 3, 4, 3, 2, 1, 0, 9, 10, 11, 12};

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
