package cs.checkers.client.frontend.builder;

import cs.checkers.client.adapter.JButtonAdapter;
import cs.checkers.client.frontend.GameWindow;
import cs.checkers.client.frontend.adapter.JPanelAdapter;
import java.awt.GridLayout;

/**
 * build a {@link GameWindow} to be used for a game of Chinese Checkers
   to create the graphics for {@link cs.checkers.client.board.VisualBoard}
   requires the field of a board to extend {@link JButtonAdapter}
 */
public class GameWindowBuilder {
  public void getGameWindow(JButtonAdapter[][] buttons) {
    JPanelAdapter board = new JPanelAdapter();
    board.setLayout(new GridLayout(buttons.length, buttons[0].length));
    for (int row = 0; row < buttons.length; row++) {
      for (int column = 0; column < buttons[0].length; column++) {
        board.add(buttons[row][column]);
      }
    }
    GameWindow window = new GameWindow(board);
    window.pack();
    window.setVisible(true);
  }
}
