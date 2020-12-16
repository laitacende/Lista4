package cs.checkers.client.board;

import javax.swing.Icon;

/**
 * representation of a tabletop game checker, right now the only way to
 * customize it's look is to set it's {@link Icon}
 */
public class VisualChecker {
  private String icon;

  public VisualChecker(String icon) {
    this.icon = icon;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

}
