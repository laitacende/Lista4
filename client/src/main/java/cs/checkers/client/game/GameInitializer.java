package cs.checkers.client.game;

import java.security.InvalidParameterException;

import cs.checkers.client.board.AbstractVisualBoard;
import cs.checkers.client.board.VisualBoard;
import cs.checkers.client.board.factory.VisualBoardFactory;
import cs.checkers.client.frontend.Controls;
import cs.checkers.client.frontend.SidePanel;
import cs.checkers.client.frontend.builder.GameWindowBuilder;
import cs.checkers.common.BoardTypes;

/**
 * initializes a game of Chinese Checkers
 */
public class GameInitializer {
  private VisualBoard board;
  private Controls controls;
  private SidePanel panel;

  /**
   * initializes {@link cs.checkers.client.frontend.GameWindow} and makes it
   * visible. This is used to show the player the current board
   */
  public void initializeGraphic() {
    controls = new Controls(board.getFields());
    for (int row = 0; row < board.getFields().length; row++) {
      for (int column = 0; column < board.getFields()[row].length; column++) {
        board.getFields()[row][column].addMouseListener(controls);
      }
    }
    panel = new SidePanel(controls);
    GameWindowBuilder builder = new GameWindowBuilder();
    builder.getGameWindow(board.getFields(), panel);
  }

  /**
   * @return current {@link VisualBoard}'s interface
   */
  AbstractVisualBoard getBoard() {
    return board;
  }

  /**
   * GameInitializer constructor
   * 
   * @param type the type of {@link VisualBoard} that the game is supposed to be
   *             based on
   */
  public GameInitializer(BoardTypes type) throws InvalidParameterException {
    board = VisualBoardFactory.getBoard(type);
    if (board == null) {
      throw new InvalidParameterException();
    }
  }

  /**
   * @return current board's controls
   */
  public Controls getControls() {
    return controls;
  }

  public SidePanel getPanel() {
    return panel;
  }
}
