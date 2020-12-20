import cs.checkers.common.CommandParser;
import cs.checkers.gamelogic.board.Board;
import cs.checkers.gamelogic.board.BoardFactory;
import cs.checkers.gamelogic.board.Corner;
import cs.checkers.gamelogic.checker.BuilderChecker;
import cs.checkers.gamelogic.checker.Checker;
import cs.checkers.gamelogic.checker.ChineseBasicCheckerBuilder;
import cs.checkers.gamelogic.field.Field;
import cs.checkers.gamelogic.movevalidator.MoveValidator;
import cs.checkers.server.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static cs.checkers.common.BoardTypes.TwoPlayerChineseCheckers;
import static org.junit.Assert.assertTrue;

public class GameSimulationTest {
    private Board board;
    private Player player1;
    private Player player2;
    private List<Checker> checkers = new ArrayList<>();
    private MoveValidator validator = new MoveValidator();
    private CommandParser parser = new CommandParser();

    @Before
    public void setUp() {
        // create a board for two players
        BoardFactory factory = new BoardFactory();
        BuilderChecker builderChecker = new ChineseBasicCheckerBuilder();
        board = factory.getBoard( TwoPlayerChineseCheckers);

        List<Corner> corners = board.getCorners();
        Corner player1Corner = corners.get(0);
        Corner player2Corner = corners.get(1);
        int numberOfCheckers = player1Corner.getFields().size(); // number of fields in one corner

        // put first player checkers in their corner
        for (int i = 0; i < numberOfCheckers; i++) {
            checkers.add(builderChecker.buildChecker());
            player1Corner.getFields().get(i).putChecker(checkers.get(i));
        }
        player1 = new Player(player1Corner);

        // put second player checkers in their corner
        int counter = 0;
        for (int i = numberOfCheckers; i < 2 * numberOfCheckers; i++) {
            checkers.add(builderChecker.buildChecker());
            player2Corner.getFields().get(counter++).putChecker(checkers.get(i));
        }
        player2 = new Player(player2Corner);
    }

    @Test
    public void simulateGame() {
        // first player
        parser.parse("move 3,11 4,10");
        Field field = board.getField(parser.getX1(), parser.getY1());
        Field next = board.getField(parser.getX2(), parser.getY2());
        Checker checker = field.getChecker();
        // check if player wants to move their checker
        if (player1 != null && validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board, player1)) {
            next.putChecker(checker);
            next.onEnter(checker);
        }
        assertTrue(next.getChecker().equals(checker));

        // now let the second player move
        parser.parse("move 13,15 12,14");
        field = board.getField(parser.getX1(), parser.getY1());
        next = board.getField(parser.getX2(), parser.getY2());
        checker = field.getChecker();
        if (player2 != null && validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board, player2)) {
            next.putChecker(checker);
            next.onEnter(checker);
        }
        assertTrue(next.getChecker().equals(checker));

        // check if player1 can move player2 checker
        parser.parse("move 13,9 12,10");
        field = board.getField(parser.getX1(), parser.getY1());
        next = board.getField(parser.getX2(), parser.getY2());
        checker = field.getChecker();
        // check if player wants to move their checker
        if (player1 != null && validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board, player1)) {
            next.putChecker(checker);
            next.onEnter(checker);
        }
        assertTrue(next.getChecker() == null);
    }
}
