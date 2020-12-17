package cs.checkers.server;

import java.net.ServerSocket;
import java.util.ArrayList;

import cs.checkers.common.BoardTypes;
import cs.checkers.gamelogic.board.Board;
import cs.checkers.gamelogic.board.BoardFactory;
import cs.checkers.gamelogic.movevalidator.MoveValidator;
import cs.checkers.parser.CommandParser;

/**
 * GameRunner
 */
public class GameRunner {
  private BoardTypes type;
  private boolean initialized = false;
  private ServerSocket serverSocket;
  private ArrayList<PlayerHandler> playerHandlers;
  private Board board;

  /**
   * Game Runner construcor
   * 
   * @param type type of Board the game is going to be played on
   */
  GameRunner(BoardTypes type) {
    this.type = type;
  }

  /**
   * method used to initialize Chinese Checkers server at a specific port, create
   * the game board and get enough players to play the game
   * 
   * @param port port on which ServerSocket will be initialized
   */
  public boolean initialize(Integer port) {
    // getting board
    BoardFactory factory = new BoardFactory();
    this.board = factory.getBoard(type);
    // getting players
    try {
      serverSocket = new ServerSocket(port);
      playerHandlers = new ArrayList<PlayerHandler>(type.getNumOfPlayers(type));
      for (int player = 0; player < type.getNumOfPlayers(type); player++) {
        try {
          playerHandlers.set(player, new PlayerHandler(serverSocket.accept()));
          playerHandlers.get(player).sendCommand(type.toString());
          if (playerHandlers.get(player).getResponse() != "OK") {
            player--;
          }
        } catch (Exception e) {
          player--;
        }
      }
    } catch (Exception e) {
      return false;
    }
    // assigning players to corners
    for (int player = 0; player < playerHandlers.size(); player++) {
      playerHandlers.get(player).setPlayer(new Player(board.getCorners().get(player)));
    }
    initialized = true;
    return true;
  }

  /**
   * method used to start the main game loop, should only be used after
   * initialize()
   */
  public void run() {
    if (!initialized) {
      return;
    }
    Integer index = 0;
    MoveValidator validator = new MoveValidator();
    CommandParser parser = new CommandParser();
    while (playerHandlers.size() != 0) {
      Boolean playerRemoved = false;
      PlayerHandler currentHandler = playerHandlers.get(index);
      // signal player that it's his turn
      currentHandler.sendCommand("your_turn");
      String playerResponse = currentHandler.getResponse();
      // player makes move
      while (true) {
        if (parser.parse(playerResponse)) {
          if (validator.validateMove(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2(), board)) {
            board.move(parser.getX1(), parser.getY1(), parser.getX2(), parser.getY2());
            currentHandler.sendCommand("move_success");
            break;
          } else {
            currentHandler.sendCommand("move_wrong");
            continue;
          }
        } else {
          if (playerResponse.equals("skip_turn")) {
            break;
          } else {
            removePlayer(currentHandler);
            playerRemoved = true;
            break;
          }
        }
      }

      // check if player has finished
      if (!playerRemoved) {
        if (currentHandler.getPlayer().checkIfFinished()) {
          currentHandler.sendCommand("you_finished");
          removePlayer(currentHandler);
        }
      }

      // move on to next client
      if (index < playerHandlers.size() - 1) {
        index++;
      } else if (index == playerHandlers.size() - 1) {
        index = 0;
      }
    }
  }

  private void removePlayer(PlayerHandler handler) {
    handler.close();
    playerHandlers.remove(handler);
  }
}
