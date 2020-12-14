package cs.checkers.logic.field;


import cs.checkers.logic.checker.Checker;

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
