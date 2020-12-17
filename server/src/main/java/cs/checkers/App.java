package cs.checkers;

import cs.checkers.common.BoardTypes;
import cs.checkers.server.GameRunner;

/**
 * App
 */
public class App {
  public static void main(String[] args) {
    if (args.length != 1) {
      return;
    }
    System.out.println(args[0]);
    BoardTypes type = BoardTypes.valueOf(args[0]);
    System.out.println(type.toString());
    if (type == null) {
      return;
    }

    GameRunner runner = new GameRunner(type);
    if (!runner.initialize(4999)) {
      System.out.println("Initializing failed");
    } else {
      runner.run();
    }
  }
}
