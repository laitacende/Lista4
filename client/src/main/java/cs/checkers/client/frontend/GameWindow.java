package cs.checkers.client.frontend;

import javax.swing.JFrame;

import cs.checkers.client.frontend.adapter.JPanelAdapter;
import java.awt.BorderLayout;

/**
 * houses graphic for {@link cs.checkers.client.board.VisualBoard}
 */
public class GameWindow extends JFrame {

  public GameWindow(JPanelAdapter board) {
    this.setName("Chinese Checkers");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.add(board, BorderLayout.CENTER);
  }
	/**
	 *
	 */
	private static final long serialVersionUID = 156693827688608895L;

}
