import cs.checkers.gamelogic.board.Board;
import cs.checkers.gamelogic.board.BoardFactory;
import cs.checkers.gamelogic.checker.BuilderChecker;
import cs.checkers.gamelogic.checker.Checker;
import cs.checkers.gamelogic.checker.ChineseBasicCheckerBuilder;
import cs.checkers.gamelogic.movevalidator.MoveValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MoveValidatorTest {
    private Board board;
    private MoveValidator validator = new MoveValidator();
    private Checker[] checkers;
    private BoardFactory factory = new BoardFactory();

    @Before
    public void setUp() {
        BuilderChecker builderChecker = new ChineseBasicCheckerBuilder();
        board = factory.getBoard("2PlayerChineseCheckersBoard");
        checkers = new Checker[10];
        for(int  i = 0; i < 10; i++) {
            checkers[i] = builderChecker.buildChecker();
        }
    }

    @Test
    public void moveToUnavailableField() {
        board.getField(0, 24).putChecker(checkers[0]);
        assertFalse(validator.validateMove("move 0,24 0,23", board));

        resetBoard();
    }

    @Test
    public void testMoveOneSquare() {
        board.getField(7, 11).putChecker(checkers[0]);
        assertTrue(board.getField(7,11).getChecker() != null);

        // check every direction without any other checkers
        assertTrue(validator.validateMove("move 7,11 7,9", board));
        assertTrue(validator.validateMove("move 7,11 7,13", board));
        assertTrue(validator.validateMove("move 7,11 6,10", board));
        assertTrue(validator.validateMove("move 7,11 6,12", board));
        assertTrue(validator.validateMove("move 7,11 8,10", board));
        assertTrue(validator.validateMove("move 7,11 8,12", board));

        // now place other checkers on some fields
        board.getField(7, 13).putChecker(checkers[1]);
        board.getField(8, 12).putChecker(checkers[2]);
        board.getField(6, 10).putChecker(checkers[3]);
        assertTrue(board.getField(7,13).getChecker() != null);
        assertTrue(board.getField(8,12).getChecker() != null);
        assertTrue(board.getField(6,10).getChecker() != null);

       // perform the same moves
        assertTrue(validator.validateMove("move 7,11 7,9", board));
        assertFalse(validator.validateMove("move 7,11 7,13", board));
        assertFalse(validator.validateMove("move 7,11 6,10", board));
        assertTrue(validator.validateMove("move 7,11 6,12", board));
        assertTrue(validator.validateMove("move 7,11 8,10", board));
        assertFalse(validator.validateMove("move 7,11 8,12", board));

        resetBoard();
    }

    @Test
    public void moveJumpTest() {
        board.getField(11, 13).putChecker(checkers[0]);
        board.getField(10, 14).putChecker(checkers[1]);
        // jump over one checker
        assertTrue(validator.validateMove("move 11,13 9,15", board));
        // try to jump
        assertFalse(validator.validateMove("move 11,13 6,18", board));
        // jump over two
        board.getField(8, 16).putChecker(checkers[2]);

        assertTrue(validator.validateMove("move 11,13 7,17", board));
        assertFalse(validator.validateMove("move 11,13 6,18", board));

        // check for polyline path
        assertTrue(validator.validateMove("move 11,13 7,15", board));

        // put another one
        board.getField(6, 14).putChecker(checkers[3]);

        // check polyline path again
        assertTrue(validator.validateMove("move 11,13 5,13", board));
        assertTrue(validator.validateMove("move 11,13 5,15", board));

        assertFalse(validator.validateMove("move 11,13 6,18", board));

        assertTrue(validator.validateMove("move 11,13 11,13", board));

        resetBoard();
    }

    @Test
    public void endlessLoopTest() {
        board.getField(10,12 ).putChecker(checkers[0]);
        board.getField(9, 11).putChecker(checkers[1]);;
        board.getField(9, 13).putChecker(checkers[2]);
        board.getField(7, 11).putChecker(checkers[3]);
        board.getField(7, 13).putChecker(checkers[4]);

        assertFalse(validator.validateMove("move 10,12 10,16", board));

        resetBoard();
    }

    @Test
    public void checkCircleOne() {
        board.getField(10,10 ).putChecker(checkers[0]);
        board.getField(9, 9).putChecker(checkers[1]);;
        board.getField(7, 7).putChecker(checkers[2]);
        board.getField(5, 7).putChecker(checkers[3]);
        board.getField(5, 9).putChecker(checkers[4]);
        board.getField(7, 11).putChecker(checkers[5]);

        assertTrue(validator.validateMove("move 10,10 8,12", board));
    }

    @Test
    public void checkCircleTwo() {
        board.getField(10,10 ).putChecker(checkers[0]);
        board.getField(9, 9).putChecker(checkers[1]);;
        board.getField(8, 6).putChecker(checkers[2]);
        board.getField(7, 5).putChecker(checkers[3]);
        board.getField(5, 7).putChecker(checkers[4]);
        board.getField(4, 10).putChecker(checkers[5]);
        board.getField(5, 13).putChecker(checkers[6]);
        board.getField(7, 13).putChecker(checkers[7]);

        assertTrue(validator.validateMove("move 10,10 8,12", board));
        assertFalse(validator.validateMove("move 10,10 9,13", board));

        resetBoard();
    }

    @Test
    public void blockedTest() {
        board.getField(16, 12).putChecker(checkers[0]);
        board.getField(15, 11).putChecker(checkers[1]);
        board.getField(15, 13).putChecker(checkers[2]);
        board.getField(14, 10).putChecker(checkers[3]);
        board.getField(14, 12).putChecker(checkers[4]);
        board.getField(14, 14).putChecker(checkers[5]);
        board.getField(13, 9).putChecker(checkers[6]);
        board.getField(13, 11).putChecker(checkers[7]);
        board.getField(13, 13).putChecker(checkers[8]);
        board.getField(13, 15).putChecker(checkers[9]);

        assertFalse(validator.validateMove("move 16,12 12,10", board));
    }

    public void resetBoard() {
        board = factory.getBoard("2PlayerChineseCheckersBoard");
    }
}
