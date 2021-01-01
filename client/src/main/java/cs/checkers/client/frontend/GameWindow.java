package cs.checkers.client.frontend;

import javax.swing.*;

import cs.checkers.client.frontend.adapter.JPanelAdapter;

import java.awt.*;

/**
 * houses graphic for {@link cs.checkers.client.board.VisualBoard}
 */
public class GameWindow extends JFrame {
  public GameWindow(JPanelAdapter board, SidePanel panel) {
    this.setName("Chinese Checkers");
    this.setPreferredSize(new Dimension(1300, 700));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.add(board, BorderLayout.CENTER);
    this.add(panel, BorderLayout.EAST);
  }
	/**
	 *
	 */
	private static final long serialVersionUID = 156693827688608895L;

}
