package cs.checkers.client.game;

import cs.checkers.client.board.AbstractVisualBoard;
import cs.checkers.client.board.VisualBoard;
import cs.checkers.common.BoardTypes;

/**
 * GameInitializer
 */
public class GameInitializer {
  BoardTypes type;
  VisualBoard board;

  //TODO: Implement method
  public void initializeGraphic() {
  }

  //TODO: Implement method
  AbstractVisualBoard initializeBoard() {
    return new VisualBoard();
  }

  public GameInitializer(BoardTypes type) {
    this.type = type;
  }

}
