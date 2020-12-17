package cs.checkers.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * PlayerHandler class used to handle communication with Player
 */
public class PlayerHandler {
  private Socket clientSocket;
  private PrintStream serverOutput;
  private Scanner clientInput;
  private Player player;

  public PlayerHandler(Socket clientSocket) throws IOException {
    this.clientSocket = clientSocket;
    serverOutput = new PrintStream(clientSocket.getOutputStream());
    clientInput = new Scanner(clientSocket.getInputStream());
  }

  public void sendCommand(String command) {
    serverOutput.println(command);
  }

  /**
   * @return client input or "disconnected" if the client disconnected
   */
  public String getResponse() {
    try {
      return clientInput.nextLine();
    } catch (Exception e) {
      return "disconnected";
    }
  }

  /**
   * closes communication with Player, should always be called if we don't plan to
   * communicate with him again
   */
  public void close() {
    try {
      clientSocket.close();
    } catch (Exception e) {
    }
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Player getPlayer() {
    return player;
  }
}
