import cs.checkers.logic.checker.Checker;
import cs.checkers.logic.checker.ManagerChecker;
import cs.checkers.logic.move.MoveJump;
import cs.checkers.logic.move.MoveOneSquare;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CheckerBuilderTest {
    ManagerChecker manager  = new ManagerChecker();

    @Test
    public void basicCheckerBuilder() {
        Checker checker = manager.buildChecker("chinese basic");

        // check if move set was built properly
        assertTrue(checker.getMoveSet().getMoves().get(0) instanceof  MoveOneSquare);
        assertTrue(checker.getMoveSet().getMoves().get(1) instanceof MoveJump);
    }

    @Test
    public void nullTest() {
        Checker checker = manager.buildChecker(" ");
        assertTrue(checker == null);
    }
}
