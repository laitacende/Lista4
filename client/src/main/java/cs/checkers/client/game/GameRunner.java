package cs.checkers.client.game;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


import cs.checkers.client.board.AbstractVisualBoard;
import cs.checkers.client.networkIO.ServerHandler;
import cs.checkers.common.BoardTypes;

/**
 * main Chinese Checkers game loop happens here
 */
public class GameRunner {
  private AbstractVisualBoard board;
  private ServerHandler handler;
  private Socket userSocket;
  private Scanner userInput;
  private boolean keepRunning;
  private boolean initialized = false;

  /**
   * use this function to connect {@link GameRunner} to a server and launch the
   * game window
   * 
   * @param ip   ip of the server we're trying to connect to
   * @param port port we're trying to connect to
   * @return returns true if connection succeeded, returns false otherwise
   */
  public boolean initialize(String ip, Integer port) {
    userSocket = new Socket();
    try {
      userInput = new Scanner(userSocket.getInputStream());
      Socket serverSocket = new Socket(ip, port);
      handler = new ServerHandler(serverSocket);
      String type = handler.getResponse();
      GameInitializer initializer = new GameInitializer(BoardTypes.valueOf(type), userSocket.getOutputStream());
      board = initializer.getBoard();
      initializer.initializeGraphic();
      initialized = true;
      return true;
    } catch (IOException e) {
      return false;
    }
  }

  /**
   * use this function to start the main game loop, requires previous use of
   * initialize()
   */
  public void run() {
    if (!initialized) {
      return;
    }
    processCommand(handler.getResponse());
    while (keepRunning) {
      String userMove = userInput.nextLine();
      handler.sendCommand(userMove);
      processCommand(handler.getResponse(), userMove);
    }

    try {
      userSocket.close();
      handler.close();
    } catch (IOException e) {
    }
  }

  private void processCommand(String command) {
  }

  private void processCommand(String command, String userMove) {
  }
}
