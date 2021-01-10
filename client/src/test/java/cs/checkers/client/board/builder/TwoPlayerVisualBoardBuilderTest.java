package cs.checkers.client.board.builder;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import cs.checkers.client.board.VisualBoard;
import cs.checkers.client.frontend.adapter.JPanelAdapter;

/**
 * TwoPlayerVisualBoardBuilderTest
 */
public class TwoPlayerVisualBoardBuilderTest extends AbstractVisualBoardBuilderTest {
  // manual test, put @Test above it and run a single method
  public void testBoard() {
    TwoPlayerVisualBoardBuilder builder = new TwoPlayerVisualBoardBuilder();
    VisualBoard board = builder.getBoard();
    JPanelAdapter panel = new JPanelAdapter();
    panel.setLayout(new GridLayout(17, 25));
    for (int i = 0; i < board.getFields().length; i++) {
      for (int j = 0; j < board.getFields()[i].length; j++) {
        panel.add(board.getFields()[i][j]);
      }
    }
    JFrame frame = new JFrame("Builder test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.add(panel, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
    try {
      Thread.sleep(3000000);
    } catch (Exception e) {
    }
  }

  @Override
  protected VisualBoard createBoard() {
    VisualBoardBuilder builder = new TwoPlayerVisualBoardBuilder();
    return builder.getBoard();
  }
}
