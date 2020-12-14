package cs.checkers.gamelogic.board;

public class BoardFactory {
    BoardBuilder builder;
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
