package cs.checkers.client.frontend;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cs.checkers.client.adapter.JButtonAdapter;
import cs.checkers.client.board.Coordinates;

/**
 * Controls
 */
public class Controls implements MouseListener {
  private String currentMove = "";
  private Integer numberOfClicks = 0;
  Coordinates previouslyClicked;
  JButtonAdapter fields[][];

  @Override
  public void mouseClicked(MouseEvent arg0) {
    if (arg0.getSource() instanceof JButtonAdapter) {
      if (numberOfClicks == 0) {
        previouslyClicked = findCoordinates((JButtonAdapter) arg0.getSource());
        numberOfClicks++;
        System.out.println("previous field set");
      } else {
        Coordinates target = findCoordinates((JButtonAdapter) arg0.getSource());
        if (target != null && previouslyClicked != null) {
          currentMove = "move " + previouslyClicked.toString() + " " + target.toString();
        }
        numberOfClicks = 0;
        System.out.println("current move set");
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

  public String getNextMove() {
    while (currentMove.equals("")) {
      try {
        Thread.sleep(5);
      } catch (InterruptedException e) {
      }
    }
    String result = currentMove;
    currentMove = "";
    return result;
  }

  public Controls(JButtonAdapter[][] fields) {
    this.fields = fields;
  }
}
