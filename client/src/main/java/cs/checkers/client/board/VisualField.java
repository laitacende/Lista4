package cs.checkers.client.board;

import java.awt.Color;

import javax.swing.Icon;

import cs.checkers.client.adapter.JButtonAdapter;

/**
 * representation of a tabletop game field, you can set it's look and fill it
 * with {@link VisualChecker}
 */
public class VisualField extends JButtonAdapter {
  private static final long serialVersionUID = -2724961121194281328L;
  private VisualChecker checker;

  public VisualField(Color backgroundColor) {
    super();
    this.setBackground(backgroundColor);
  }


  /**
   * @return returns the current {@link VisualChecker} on this field
   */
  public VisualChecker getChecker() {
    return checker;
  }

  /**
   * sets the current checker
   * 
   * @param checker {@link VisualChecker} to set as current
   */
  public void setChecker(VisualChecker checker) {
    this.checker = checker;
    onEnter(checker);
  }

  /**
     @return returns the {@link Icon} of the current {@link VisualChecker}
   */
  public String getIconString() {
    if (checker != null) {
      return checker.getIcon();
    } else {
      return null;
    }
  }

  private void onEnter(VisualChecker checker) {
    if (checker != null) {
      this.setText(checker.getIcon());
    } else {
      this.setText("");
    }
  }
}
