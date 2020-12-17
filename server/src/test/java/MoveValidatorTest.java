import cs.checkers.common.CommandParser;
import cs.checkers.gamelogic.board.Board;
import cs.checkers.gamelogic.board.BoardFactory;
import cs.checkers.gamelogic.checker.BuilderChecker;
import cs.checkers.gamelogic.checker.Checker;
import cs.checkers.gamelogic.checker.ChineseBasicCheckerBuilder;
import cs.checkers.gamelogic.movevalidator.MoveValidator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static cs.checkers.common.BoardTypes.TwoPlayerChineseCheckers;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MoveValidatorTest {
    private Board board;
    private MoveValidator validator = new MoveValidator();
    private Checker[] checkers;
    private BoardFactory factory = new BoardFactory();
    private CommandParser parser = new CommandParser();

    @Before
    public void setUp() {
        BuilderChecker builderChecker = new ChineseBasicCheckerBuilder();
        board = factory.getBoard(TwoPlayerChineseCheckers);
        checkers = new Checker[10];
        for(int  i = 0; i < 10; i++) {
            checkers[i] = builderChecker.buildChecker();
        }
    }

    @Test
    public void moveToUnavailableField() {
        board.getField(0, 24).putChecker(checkers[0]);
        parser.parse("move 0,24 0,23");
        assertFalse(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));

        resetBoard();
    }

    @Test
    public void testMoveOneSquare() {
        board.getField(7, 11).putChecker(checkers[0]);
        assertTrue(board.getField(7,11).getChecker() != null);

        // check every direction without any other checkers
        parser.parse("move 7,11 7,9");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));
        parser.parse("move 7,11 7,13");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));
        parser.parse("move 7,11 6,10");
        assertTrue(validator.validateMove( parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));
        parser.parse("move 7,11 6,12");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));
        parser.parse("move 7,11 8,10");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));
        parser.parse("move 7,11 8,12");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));

        // now place other checkers on some fields
        board.getField(7, 13).putChecker(checkers[1]);
        board.getField(8, 12).putChecker(checkers[2]);
        board.getField(6, 10).putChecker(checkers[3]);
        assertTrue(board.getField(7,13).getChecker() != null);
        assertTrue(board.getField(8,12).getChecker() != null);
        assertTrue(board.getField(6,10).getChecker() != null);

       // perform the same moves
        parser.parse("move 7,11 7,9");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));
        parser.parse("move 7,11 7,13");
        assertFalse(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));
        parser.parse("move 7,11 6,10");
        assertFalse(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));
        parser.parse("move 7,11 6,12");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));
        parser.parse("move 7,11 8,10");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));
        parser.parse("move 7,11 8,12");
        assertFalse(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));

        resetBoard();
    }

    @Test
    public void moveJumpTest() {
        board.getField(11, 13).putChecker(checkers[0]);
        board.getField(10, 14).putChecker(checkers[1]);

        // jump over one checker
        parser.parse("move 11,13 9,15");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));

        // try to jump
        parser.parse("move 11,13 6,18");
        assertFalse(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));

        // jump over two
        board.getField(8, 16).putChecker(checkers[2]);

        parser.parse("move 11,13 7,17");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));
        parser.parse("move 11,13 6,18");
        assertFalse(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));

        // check for polyline path
        parser.parse("move 11,13 7,15");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));

        // put another one
        board.getField(6, 14).putChecker(checkers[3]);

        // check polyline path again
        parser.parse("move 11,13 5,13");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));
        parser.parse("move 11,13 5,15");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));

        parser.parse("move 11,13 6,18");
        assertFalse(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));

        parser.parse("move 11,13 11,13");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));

        resetBoard();
    }

    @Test
    public void endlessLoopTest() {
        board.getField(10,12 ).putChecker(checkers[0]);
        board.getField(9, 11).putChecker(checkers[1]);;
        board.getField(9, 13).putChecker(checkers[2]);
        board.getField(7, 11).putChecker(checkers[3]);
        board.getField(7, 13).putChecker(checkers[4]);

        parser.parse("move 10,12 10,16");
        assertFalse(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));

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

        parser.parse("move 10,10 8,12");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));
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

        parser.parse("move 10,10 8,12");
        assertTrue(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));
        parser.parse("move 10,10 9,13");
        assertFalse(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));

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

        parser.parse("move 16,12 12,10");
        assertFalse(validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board));
    }

    public void resetBoard() {
        board = factory.getBoard(TwoPlayerChineseCheckers);
    }
}
