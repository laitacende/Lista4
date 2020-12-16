import cs.checkers.gamelogic.board.Board;
import cs.checkers.gamelogic.board.BoardFactory;
import cs.checkers.gamelogic.board.Corner;
import cs.checkers.gamelogic.checker.BuilderChecker;
import cs.checkers.gamelogic.checker.Checker;
import cs.checkers.gamelogic.checker.ChineseBasicCheckerBuilder;
import cs.checkers.gamelogic.field.Field;
import cs.checkers.server.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static cs.checkers.common.BoardTypes.TwoPlayerChineseCheckers;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
    Board board;
    Player player1;
    List<Corner> corners;
    List<Checker> checkers = new ArrayList<>();
    List<Field> fieldsInCorner;

    @Before
    public void setUp() {
        BoardFactory factory = new BoardFactory();
        BuilderChecker builderChecker = new ChineseBasicCheckerBuilder();
        board = factory.getBoard(TwoPlayerChineseCheckers);
        corners = board.getCorners();
        fieldsInCorner = corners.get(0).getFields();

        // put checkers in corner
        for (int i = 0; i < fieldsInCorner.size(); i++) {
            checkers.add(builderChecker.buildChecker());
            fieldsInCorner.get(i).putChecker(checkers.get(i));
        }

        // give player corner and checkers in it
        player1 = new Player(corners.get(0));
    }

    @Test
    public void testIfFinished() {
        List<Field> oppositeFields = corners.get(0).getOppositeCorner().getFields();

        assertFalse(player1.checkIfFinished());

        // now move checkers to opposite corner (so the 'home' for this player)
        for (int i = 0; i < fieldsInCorner.size(); i++) {
            fieldsInCorner.get(i).takeChecker();
            oppositeFields.get(i).putChecker(checkers.get(i));
        }

        assertTrue(player1.checkIfFinished());
    }
}
