package cs.checkers.logic.Field;


import cs.checkers.logic.Checker.Checker;

public abstract class Field {
    private int x;
    private int y;
    private Checker checker = null;

    public abstract void onEnter(Checker chcecker);

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void putChecker(Checker checker) {
        this.checker = checker;
    }

    public Checker getChecker() {
        return checker;
    }
}
