package cs.checkers.client.board;

/**
 * VisualBoard
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
