package cs.checkers.client.networkIO;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * handles communication with server in a game of Chinese Checkers
 */
public class ServerHandler {
  private Scanner serverOutput;
  private PrintStream clientOutput;
  private Socket serverSocket;

  public ServerHandler(Socket server) throws IOException {
    clientOutput = new PrintStream(server.getOutputStream());
    serverOutput = new Scanner(server.getInputStream());
    serverSocket = server;
  }

  public void sendCommand(String command) {
    clientOutput.println(command);
  }

  public String getResponse() {
    return serverOutput.nextLine();
  }

  public void close() throws IOException {
    serverSocket.close();
  }

}
