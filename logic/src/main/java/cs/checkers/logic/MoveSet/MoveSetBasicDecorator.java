package cs.checkers.logic.MoveSet;

import cs.checkers.logic.Move.MoveJump;
import cs.checkers.logic.Move.MoveOneSquare;

public class MoveSetBasicDecorator extends MoveSetDecorator {
   public MoveSetBasicDecorator(AbstractMoveSet moveSet) {
       super(moveSet);
   }

    @Override
    public void addMove() {
        moveSet.addMoveToList(new MoveOneSquare());
        moveSet.addMoveToList(new MoveJump());
        super.addMove();
    }
}
