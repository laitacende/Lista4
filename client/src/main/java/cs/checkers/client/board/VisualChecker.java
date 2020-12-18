package cs.checkers.client.board;

import javax.swing.Icon;
import java.awt.Color;

/**
 * representation of a tabletop game checker, right now the only way to
 * customize it's look is to set it's {@link Icon}
 */
public class VisualChecker {
  private String icon;
  private Color color;

  public VisualChecker(String icon) {
    this.icon = icon;
  }

  public VisualChecker(String icon, Color color) {
    this.icon = icon;
    this.color = color;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

}
