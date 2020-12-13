import cs.checkers.logic.Move.MoveJump;
import cs.checkers.logic.Move.MoveOneSquare;
import cs.checkers.logic.MoveSet.AbstractMoveSet;
import cs.checkers.logic.MoveSet.MoveSet;
import cs.checkers.logic.MoveSet.MoveSetBasicDecorator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MoveSetDecoratorTest {
    @Test
    public void testDecorator() {
        AbstractMoveSet moveSet = new MoveSet();
        moveSet = new MoveSetBasicDecorator(moveSet);
        moveSet.addMove();
        assertTrue(moveSet.getMoves().get(0) instanceof MoveOneSquare);
        assertTrue(moveSet.getMoves().get(1) instanceof MoveJump);
    }
}
