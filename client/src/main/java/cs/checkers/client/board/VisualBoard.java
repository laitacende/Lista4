package cs.checkers.client.board;

/**
 * VisualBoard -- code representation of a Chinese Checkers board, consists of multiples
   of {@link VisualField}, which determine the look of the board.
 */
public class VisualBoard implements AbstractVisualBoard {
  private VisualField[][] fields;

	@Override
	public void move(Integer fromX, Integer fromY, Integer toX, Integer toY) {
    try {
      fields[toX][toY].setChecker(fields[fromX][fromY].getChecker());
    } catch (Exception e) {
    }
	}

	public VisualField[][] getFields() {
		return fields;
	}

	public void setFields(VisualField[][] fields) {
		this.fields = fields;
	}

}
