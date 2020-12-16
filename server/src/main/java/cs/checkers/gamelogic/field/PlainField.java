package cs.checkers.gamelogic.field;

import cs.checkers.gamelogic.checker.Checker;

/**
 * Basic field for game.
 */
public class PlainField extends Field {
    /**
     * Method which defines behaviour of field. In this case, nothing happens.
     * @param checker checker to be put
     */
    @Override
    public void onEnter(Checker checker) {
        // do nothing
    }

    /**
     * Method which return 'type' of field.
     * @return true if field isn't unavailable, false if it otherwise
     */
    @Override
    public boolean isAvailable() {
        return true;
    }
}
