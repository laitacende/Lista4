package cs.checkers.logic.Checker;

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
