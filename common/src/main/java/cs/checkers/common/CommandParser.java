package cs.checkers.common;

/**
 * Class which is responsible for parsing command.
 */
public class CommandParser {
    /**
     * Row of current field.
     */
    private int x1;

    /**
     * Column of current field.
     */
    private int y1;

    /**
     * Row of next field.
     */
    private int x2;

    /**
     * Column of next field.
     */
    private int y2;

    /**
     * Method which parses command.
     * @param command command to parse
     * @return true if command was correctly formatted, false otherwise
     */
    public boolean parse(String command) {
      try {
        String[] args = splitCommand(command, " "); // coordinates at 1, 2
        String[] coordinatesPrev = splitCommand(args[1], ",");
        String[] coordinatesNext = splitCommand(args[2], ",");
        x1 = Integer.parseInt(coordinatesPrev[0]);
        y1 = Integer.parseInt(coordinatesPrev[1]);
        x2 = Integer.parseInt(coordinatesNext[0]);
        y2 = Integer.parseInt(coordinatesNext[1]);
      } catch (Exception e) {
        return false;
      }
      return true;
    }

    /**
     * Method which splits command with specified separator.
     * @param command command to split
     * @param separator separator
     * @return split command
     */
    private String[] splitCommand(String command, String separator) {
        String[] result = command.split(separator);
        return result;
    }

    /**
     * x1 getter.
     * @return x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * x2 getter.
     * @return x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * y1 getter.
     * @return y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * y2 getter
     * @return y2
     */
    public int getY2() {
        return y2;
    }
}
