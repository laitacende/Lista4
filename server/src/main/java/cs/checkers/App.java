package cs.checkers;

import cs.checkers.common.BoardTypes;
import cs.checkers.server.GameRunner;

import java.net.ServerSocket;

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

    try {
      ServerSocket serverSocket = new ServerSocket(4999);

      GameRunner runner = new GameRunner(type, serverSocket);
      if (!runner.initialize()) {
        System.out.println("Initializing failed");
      } else {
        runner.run();
      }
    }
    catch (Exception e) {
      System.out.println("Failed to create socket");
    }
  }
}
