package cs.checkers.client.board;

import javax.swing.Icon;

/**
 * VisualChecker
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
