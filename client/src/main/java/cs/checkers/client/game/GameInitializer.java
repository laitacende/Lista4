package cs.checkers.client.game;

import java.security.InvalidParameterException;

import cs.checkers.client.board.AbstractVisualBoard;
import cs.checkers.client.board.VisualBoard;
import cs.checkers.client.board.factory.VisualBoardFactory;
import cs.checkers.client.frontend.Controls;
import cs.checkers.client.frontend.builder.GameWindowBuilder;
import cs.checkers.common.BoardTypes;

/**
 * initializes a game of Chinese Checkers
 */
public class GameInitializer {
  private VisualBoard board;
  private Controls controls;

  public void initializeGraphic() {
    controls = new Controls(board.getFields());
    for (int row = 0; row < board.getFields().length; row++) {
      for (int column = 0; column < board.getFields()[row].length; column++) {
        board.getFields()[row][column].addMouseListener(controls);
      }
    }
    GameWindowBuilder builder = new GameWindowBuilder();
    builder.getGameWindow(board.getFields());
  }

  AbstractVisualBoard getBoard() {
    return board;
  }

  public GameInitializer(BoardTypes type) throws InvalidParameterException {
    board = VisualBoardFactory.getBoard(type);
    if (board == null) {
      throw new InvalidParameterException();
    }
  }

  public Controls getControls() {
    return controls;
  }

}
