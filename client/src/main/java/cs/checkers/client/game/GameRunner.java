package cs.checkers.client.game;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

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

  private void initialize() throws IOException {
    userSocket = new Socket();
    userInput = new Scanner(userSocket.getInputStream());
    Socket serverSocket = new Socket("localhost", 4999);
    handler = new ServerHandler(serverSocket);
    String type = handler.getResponse();
    GameInitializer initializer = new GameInitializer(BoardTypes.valueOf(type), userSocket.getOutputStream());
    board = initializer.getBoard();
    initializer.initializeGraphic();
  }

  public void run() {
    try {
      initialize();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Initializing failed, exiting");
      return;
    }

    processCommand(handler.getResponse());
    while(keepRunning) {
      String userMove = userInput.nextLine();
      handler.sendCommand(userMove);
      processCommand(handler.getResponse(), userMove);

    }
  }

  private void processCommand(String command) {
  }

  private void processCommand(String command, String userMove) {
    
  }
}
