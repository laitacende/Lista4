import cs.checkers.logic.move.MoveJump;
import cs.checkers.logic.move.MoveOneSquare;
import cs.checkers.logic.moveset.AbstractMoveSet;
import cs.checkers.logic.moveset.MoveSet;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MoveSetTest {

    @Test
    public void testMoveSet() {
        AbstractMoveSet moveSet = new MoveSet();
        moveSet.addMoveToList(new MoveOneSquare());
        moveSet.addMoveToList(new MoveJump());
        assertTrue(moveSet.getMoves().get(0) instanceof MoveOneSquare);
        assertTrue(moveSet.getMoves().get(1) instanceof MoveJump);
    }
}