package cs.checkers.client.frontend;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintStream;

import cs.checkers.client.adapter.JButtonAdapter;
import cs.checkers.client.board.Coordinates;
/**
 * Controls
 */
public class Controls implements MouseListener {
  private PrintStream userInput;
  private Integer numberOfClicks = 0;
  Coordinates previouslyClicked;
  JButtonAdapter fields[][];

	@Override
	public void mouseClicked(MouseEvent arg0) {
    if (arg0.getSource() instanceof JButtonAdapter) {
      if (numberOfClicks == 0) {
        previouslyClicked = findCoordinates((JButtonAdapter) arg0.getSource());
      } else {
        Coordinates target = findCoordinates((JButtonAdapter) arg0.getSource());
        if (target != null && previouslyClicked != null) {
          userInput.println("move " + previouslyClicked.toString() + " " + target.toString());
        }
        numberOfClicks = 0;
      }
    }
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	public Controls(PrintStream userInput, JButtonAdapter[][] fields) {
		this.userInput = userInput;
		this.fields = fields;
	}

  private Coordinates findCoordinates(JButtonAdapter field) {
    for (int row = 0; row < fields.length; row++) {
      for (int column = 0; column < fields[row].length; column++) {
        if (fields[row][column] == field) {
          return new Coordinates(row, column);
        }
      }
    }
    return null;
  }
}
