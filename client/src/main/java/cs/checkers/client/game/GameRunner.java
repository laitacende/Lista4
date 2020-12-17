package cs.checkers.client.game;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

import cs.checkers.client.board.AbstractVisualBoard;
import cs.checkers.client.board.Coordinates;
import cs.checkers.client.frontend.Controls;
import cs.checkers.client.networkIO.ServerHandler;
import cs.checkers.common.BoardTypes;
import cs.checkers.common.CommandParser;

/**
 * main Chinese Checkers game loop happens here
 */
public class GameRunner {
  private AbstractVisualBoard board;
  private ServerHandler handler;
  private boolean keepRunning = true;
  private boolean initialized = false;
  private String currentMove;
  private Controls controls;

  /**
   * use this function to connect {@link GameRunner} to a server and launch the
   * game window
   * 
   * @param ip   ip of the server we're trying to connect to
   * @param port port we're trying to connect to
   * @return returns true if connection succeeded, returns false otherwise
   */
  public boolean initialize(String ip, Integer port) {
    try {
      Socket serverSocket = new Socket(ip, port);
      System.out.println("Connected to server");
      handler = new ServerHandler(serverSocket);
      String type = handler.getResponse();
      GameInitializer initializer = new GameInitializer(BoardTypes.valueOf(type));
      board = initializer.getBoard();
      initializer.initializeGraphic();
      this.controls = initializer.getControls();
      handler.sendCommand("OK");
      initialized = true;
      System.out.println("Initialization done");
    } catch (IOException e) {
      return false;
    }
    return true;
  }

  /**
   * use this function to start the main game loop, requires previous use of
   * initialize()
   */
  public void run() {
    if (!initialized) {
      return;
    }
    while (keepRunning) {
      try {
        System.out.println("entering processCommands");
        processCommand(handler.getResponse());
      } catch (Exception er) {
        JOptionPane.showMessageDialog(null, "Server disconnected, game exited");
        er.printStackTrace();
        keepRunning = false;
      }
    }

    try {
      handler.close();
    } catch (IOException e) {
    }
  }

  private void processCommand(String command) {
    System.out.println("got response from server: " + command);
    CommandParser parser = new CommandParser();
    switch (command) {
      case "your_turn":
        currentMove = createMove();
        handler.sendCommand(currentMove);
        break;
      case "move_success":
        parser.parse(currentMove);
        board.move(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2());
        break;
      case "move_wrong":
        JOptionPane.showMessageDialog(null, "Wrong move, try again");
        break;
      case "you_finished":
        JOptionPane.showMessageDialog(null, "You finished");
        break;
    }
  }

  private String createMove() {
    System.out.println("getting moves from fronted");
    String move = controls.getNextMove();
    System.out.println("moves gotten from frontend");
    return move;
  }

}
