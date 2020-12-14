package cs.checkers.client.board;

import javax.swing.Icon;

import cs.checkers.client.adapter.JButtonAdapter;

/**
 * VisualField
 */
public class VisualField extends JButtonAdapter {
  /**
   *
   */
  private static final long serialVersionUID = -2724961121194281328L;
  private VisualChecker checker;

  public VisualChecker getChecker() {
    return checker;
  }

  public void setChecker(VisualChecker checker) {
    this.checker = checker;
    onEnter(checker);
  }

  @Override
  public Icon getIcon() {
    if (checker != null) {
      return checker.getIcon();
    } else {
      return null;
    }
  }

  private void onEnter(VisualChecker checker) {
    this.setIcon(checker.getIcon());
  }

}
