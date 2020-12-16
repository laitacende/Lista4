package cs.checkers.gamelogic.checker;

/**
 * Manager for builders of checkers.
 * @see cs.checkers.gamelogic.checker.BuilderChecker
 * @see cs.checkers.gamelogic.checker.Checker
 */
public class ManagerChecker {
    private BuilderChecker builder;

    public Checker buildChecker(String type) {
        if (type.equals("chinese basic")) {
            builder = new ChineseBasicCheckerBuilder();
            return builder.buildChecker();
        }
        return null;
    }
}
