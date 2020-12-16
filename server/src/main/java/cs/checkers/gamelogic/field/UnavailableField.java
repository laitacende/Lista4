package cs.checkers.gamelogic.field;


import cs.checkers.gamelogic.checker.Checker;

public class UnavailableField extends Field {

    /**
     * Method which defines behaviour of field. In this case, nothing happens.
     * @param checker checker to be put
     */
    @Override
    public void onEnter(Checker checker) {

    }

    @Override
    public void putChecker(Checker checker) {

    }

    @Override
    public void takeChecker() {

    }

    @Override
    public Checker getChecker() {
       return null;
    }

    /**
     * Method which return 'type' of field.
     * @return true if field isn't unavailable, false if it otherwise
     */
    @Override
    public boolean isAvailable() {
        return false;
    }
}
