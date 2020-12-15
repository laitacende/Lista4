package cs.checkers.gamelogic.field;


import cs.checkers.gamelogic.checker.Checker;

public abstract class Field {
    private int x;
    private int y;
    protected Checker checker = null;

    public abstract void onEnter(Checker checker);

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

    public void takeChecker() {
        this.checker = null;
    }

    public Checker getChecker() {
        return checker;
    }

    public abstract boolean isAvailable();
}
