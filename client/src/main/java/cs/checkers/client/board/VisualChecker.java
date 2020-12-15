package cs.checkers.client.board;

import javax.swing.Icon;

/**
 * representation of a tabletop game checker, right now the only way to
 * customize it's look is to set it's {@link Icon}
 */
public class VisualChecker {
  private Icon icon;

  public VisualChecker(Icon icon) {
    this.icon = icon;
  }

  public Icon getIcon() {
    return icon;
  }

  public void setIcon(Icon icon) {
    this.icon = icon;
  }

}
