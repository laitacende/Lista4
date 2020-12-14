package cs.checkers.gamelogic.field;


import cs.checkers.gamelogic.checker.Checker;

public class UnavailableField extends Field {

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
}
