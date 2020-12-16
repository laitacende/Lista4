package cs.checkers.parser;

public class CommandParser {
    int x1;
    int y1;
    int x2;
    int y2;

    public void parse(String command) {
        String[] args = splitCommand(command, " "); // coordinates at 1, 2
        String[] coordinatesPrev = splitCommand(args[1], ",");
        String[] coordinatesNext = splitCommand(args[2], ",");
        x1 = Integer.parseInt(coordinatesPrev[0]);
        y1 = Integer.parseInt(coordinatesPrev[1]);
        x2 = Integer.parseInt(coordinatesNext[0]);
        y2 = Integer.parseInt(coordinatesNext[1]);
    }

    private String[] splitCommand(String command, String separator) {
        String[] result = command.split(separator);
        return result;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }
}
