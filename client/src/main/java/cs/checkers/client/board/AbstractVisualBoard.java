package cs.checkers.client.board;

/**
 * general representation of a tabletop game, basically you can move around on
 * it, methods assume that the board can be displayed in a matrix
 */
public interface AbstractVisualBoard {
  /**
   * @param fromX determines the row we want to move something from
   * @param fromY determines the column we want to move something from
   * @param toX   determines the row we want to move something to
   * @param toY   determines the column we want to move something to
   */
  public void move(Integer fromX, Integer fromY, Integer toX, Integer toY);
}
