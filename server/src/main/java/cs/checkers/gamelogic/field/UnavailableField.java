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

    /**
     * Method to put checker on the field. In this case does nothing.
     * @param checker checker to be put
     */
    @Override
    public void putChecker(Checker checker) {

    }

    /**
     * Method to take checker from field. In this case does nothing.
     */
    @Override
    public void takeChecker() {

    }

    /**
     * Method to get checker that is put in this field.
     * @return null, unavailable field doesn't have checker
     */
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
