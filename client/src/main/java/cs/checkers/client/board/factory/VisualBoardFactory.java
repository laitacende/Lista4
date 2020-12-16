package cs.checkers.client.board.factory;

import cs.checkers.client.board.VisualBoard;
import cs.checkers.client.board.builder.FourPlayerVisualBoardBuilder;
import cs.checkers.client.board.builder.SixPlayerVisualBoardBuilder;
import cs.checkers.client.board.builder.ThreePlayerVisualBoardBuilder;
import cs.checkers.client.board.builder.TwoPlayerVisualBoardBuilder;
import cs.checkers.client.board.builder.VisualBoardBuilder;
import cs.checkers.common.BoardTypes;

/**
 * uses implementations of
 * {@link cs.checkers.client.board.builder.VisualBoardBuilder} to create a
 * {@link VisualBoard} of a given type in {@link BoardTypes}
 */
public class VisualBoardFactory {

  /**
   * @param type the type that the resulting board is supposed to be
   */
  public static VisualBoard getBoard(BoardTypes type) {
    VisualBoardBuilder builder;
    switch (type) {
      case TwoPlayerChineseCheckers:
        builder = new TwoPlayerVisualBoardBuilder();
        break;
      case FourPlayerChineseCheckers:
        builder = new FourPlayerVisualBoardBuilder();
        break;
      case SixPlayerChineseCheckers:
        builder = new SixPlayerVisualBoardBuilder();
        break;
      case ThreePlayerChineseCheckers:
        builder = new ThreePlayerVisualBoardBuilder();
        break;
      default:
        return null;
    }
    return builder.getBoard();
  }
}
