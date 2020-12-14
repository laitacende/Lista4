import cs.checkers.gamelogic.move.MoveJump;
import cs.checkers.gamelogic.move.MoveOneSquare;
import cs.checkers.gamelogic.moveset.AbstractMoveSet;
import cs.checkers.gamelogic.moveset.MoveSet;
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