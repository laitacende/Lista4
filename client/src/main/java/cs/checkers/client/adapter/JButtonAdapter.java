package cs.checkers.client.adapter;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 * JButtonAdapter
 */
public class JButtonAdapter extends JButton {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Override
  public void setBackground(Color bg) {
    super.setBackground(bg);
  }

  @Override
  public synchronized void addMouseListener(MouseListener l) {
    super.addMouseListener(l);
  }

  @Override
  public Color getBackground() {
    return super.getBackground();
  }

  @Override
  public Icon getIcon() {
    return super.getIcon();
  }

  @Override
  public void setIcon(Icon defaultIcon) {
    super.setIcon(defaultIcon);
  }
}
