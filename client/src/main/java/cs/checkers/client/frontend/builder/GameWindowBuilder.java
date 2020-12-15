package cs.checkers.client.frontend.builder;

import cs.checkers.client.adapter.JButtonAdapter;
import cs.checkers.client.frontend.GameWindow;

/**
 * build a {@link GameWindow} to be used for a game of Chinese Checkers
   to create the graphics for {@link cs.checkers.client.board.VisualBoard}
   requires the field of a board to extend {@link JButtonAdapter}
 */
public class GameWindowBuilder {
  //TODO: Implement method
  public GameWindow getGameWindow(JButtonAdapter[][] buttons) {
    return new GameWindow();
  }
}
