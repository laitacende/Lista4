package cs.checkers.logic.Checker;

public class ChineseBasicCheckerBuilder extends BuilderChecker {
    @Override
    public Checker buildChecker() {
        Checker checker = new ChineseBasicChecker();
        return checker;
    }
}
