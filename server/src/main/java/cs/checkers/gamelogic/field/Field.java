package cs.checkers.gamelogic.field;


import cs.checkers.gamelogic.checker.Checker;

/**
 * Class which represents field of board.
 */
public abstract class Field {
    /**
     * Row of field.
     */
    private int x;

    /**
     * Column of field.
     */
    private int y;

    /**
     * Checker which is in this field. Null if there is no checker.
     * @see cs.checkers.gamelogic.checker.Checker
     */
    protected Checker checker = null;

    /**
     * Method which defines behaviour of field.
     * @param checker checker to be put
     */
    public abstract void onEnter(Checker checker);

    /**
     * Setter for rows and column.
     * @param x row
     * @param y column
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Row (x axis) getter.
     * @return row of field
     */
    public int getX() {
        return x;
    }

    /**
     * Column (y axis) getter.
     * @return column of field
     */
    public int getY() {
        return y;
    }

    /**
     * Method to put checker on the field.
     * @param checker checker to be put
     */
    public void putChecker(Checker checker) {
        this.checker = checker;
    }

    /**
     * Method to take checker from field.
     */
    public void takeChecker() {
        this.checker = null;
    }

    /**
     * Method to get checker that is put in this field.
     * @return checker which is in this field
     */
    public Checker getChecker() {
        return checker;
    }

    /**
     * Method which return 'type' of field.
     * @return true if field isn't unavailable, false if it otherwise
     */
    public abstract boolean isAvailable();
}
