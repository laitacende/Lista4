package cs.checkers.client.networkIO;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * ServerHandler
 */
public class ServerHandler {
  private Scanner serverOutput;
  private PrintStream clientOutput;
  private Socket server;

  public ServerHandler(Socket server) {
    this.server = server;
  }

  //TODO: Implement function
  public Boolean sendCommand(String command) {
    return true;
  }

  //TODO: Implement function
  public String getResponse() {
    return "";
  }

}
