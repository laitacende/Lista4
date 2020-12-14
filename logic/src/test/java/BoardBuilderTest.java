import cs.checkers.logic.board.Board;
import cs.checkers.logic.board.BoardFactory;
import cs.checkers.logic.field.PlainField;
import cs.checkers.logic.field.UnavailableField;
import org.junit.Test;
import static org.junit.Assert.*;


public class BoardBuilderTest {
    private BoardFactory factory = new BoardFactory();
    private Board board;

    @Test
    public void TwoPlayersChineseCheckersBoardBuilder() {
        board = factory.getBoard("2PlayerChineseCheckersBoard");

        // check if board was correctly built
        assertTrue(board.getField(3,9) instanceof PlainField);
        assertTrue(board.getField(8,6) instanceof PlainField);
        assertTrue(board.getField(12,4) instanceof PlainField);

        assertTrue(board.getField(0,0) instanceof UnavailableField);
        assertTrue(board.getField(5,14) instanceof UnavailableField);
        assertTrue(board.getField(14,19) instanceof UnavailableField);

        // check corner of the first player
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 9; j < 16; j++) {
                if (board.getField(i, j) instanceof PlainField) { // plain field
                    assertEquals(board.getCorners().get(0).getFields().get(counter).getX(),i);
                    assertEquals(board.getCorners().get(0).getFields().get(counter++).getY(),j);
                }
            }
        }
        // check if opposite corner is set correctly
        assertEquals(2, board.getCorners().size());
        assertEquals(board.getCorners().get(0), board.getCorners().get(1).getOppositeCorner());
    }

    @Test
    public void ThreePlayersChineseCheckersBoardBuilder() {
        board = factory.getBoard("3PlayerChineseCheckersBoard");

        // check if board was correctly built
        assertTrue(board.getField(3,9) instanceof PlainField);
        assertTrue(board.getField(8,6) instanceof PlainField);
        assertTrue(board.getField(12,4) instanceof PlainField);

        assertTrue(board.getField(0,0) instanceof UnavailableField);
        assertTrue(board.getField(5,14) instanceof UnavailableField);
        assertTrue(board.getField(14,19) instanceof UnavailableField);
    }

    @Test
    public void FourPlayersChineseCheckersBoardBuilder() {
        board = factory.getBoard("4PlayerChineseCheckersBoard");

        // check if board was correctly built
        assertTrue(board.getField(3,9) instanceof PlainField);
        assertTrue(board.getField(8,6) instanceof PlainField);
        assertTrue(board.getField(12,4) instanceof PlainField);

        assertTrue(board.getField(0,0) instanceof UnavailableField);
        assertTrue(board.getField(5,14) instanceof UnavailableField);
        assertTrue(board.getField(14,19) instanceof UnavailableField);
    }

    @Test
    public void SixPlayersChineseCheckersBoardBuilder() {
        board = factory.getBoard("6PlayerChineseCheckersBoard");

        // check if board was correctly built
        assertTrue(board.getField(3,9) instanceof PlainField);
        assertTrue(board.getField(8,6) instanceof PlainField);
        assertTrue(board.getField(12,4) instanceof PlainField);

        assertTrue(board.getField(0,0) instanceof UnavailableField);
        assertTrue(board.getField(5,14) instanceof UnavailableField);
        assertTrue(board.getField(14,19) instanceof UnavailableField);
    }

    @Test
    public void nullBoard() {
        assertEquals(null, factory.getBoard(""));
    }
}
