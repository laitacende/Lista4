package cs.checkers.logic.MoveSet;

import cs.checkers.logic.Checker.Checker;
import cs.checkers.logic.Field.Field;

import java.util.ArrayList;
import java.util.List;

public class MoveSet extends AbstractMoveSet {
    StringBuilder sb;
    String command ="move ";


    public MoveSet() {
        moves = new ArrayList<>();
    }

    public List<String> getAvailableMoves(Field field) {
        int x = field.getX();
        int y = field.getY();
        Checker checker = field.getChecker();
        sb.append( x + "," + y);
        ArrayList<String> commands = new ArrayList<>();



        return null;
    }

    public void moveOneSquare(int x, int y) {

    }
}
