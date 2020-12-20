package cs.checkers.client.board;

import java.util.ArrayList;

/**
 * Coordinates
 */
public class Coordinates {
  public static final Integer UP = -1;
  public static final Integer DOWN = 1;
  private Integer row;
  private Integer column;

  public Coordinates(Integer row, Integer column) {
    this.row = row;
    this.column = column;
  }

  public Integer getRow() {
    return this.row;
  }

  public Integer getColumn() {
    return this.column;
  }

  public String toString() {
    return getRow().toString() + "," + getColumn().toString();
  }

  /**
   * function which returns a list of all points in a given triangle One specifies
   * the triangle by passing it's root point, it's height and whether it's
   * supposed to go down or up
   * 
   * @param xBeg              row of the triangle root
   * @param yBeg              column of the triangle root
   * @param height            triangle height
   * @param verticalDirection 1 if it's going down or -1 if it's going up
   * @return a list of all points in a triangle
   */
  public static ArrayList<Coordinates> getTrianglePoints(int xBeg, int yBeg, int height, int verticalDirection) {
    ArrayList<Coordinates> result = new ArrayList<Coordinates>();
    int xPoint = xBeg;
    int yPoint = yBeg;
    int amountOfPoints = 1;
    for (int row = 0; row < height; row++) {
      for (int point = 0; point < amountOfPoints; point++) {
        result.add(new Coordinates(xPoint, yPoint + point));
      }
      xPoint += verticalDirection;
      yPoint -= 1;
      amountOfPoints += 2;
    }
    return result;
  }
}
