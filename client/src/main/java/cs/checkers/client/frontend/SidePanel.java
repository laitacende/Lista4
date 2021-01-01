package cs.checkers.client.frontend;

import javax.swing.*;
import java.awt.*;

/**
 * Side Panel for game window.
 */
public class SidePanel extends JPanel {
    /**
     * Label signaling it's this player turn.
     */
    private JLabel label = new JLabel(" ");

    /**
     * Layout.
     */
    private GridBagLayout layout = new GridBagLayout();

    /**
     * Layout constraints.
     */
    private GridBagConstraints c = new GridBagConstraints();

    /**
     * Button to skip turn;
     */
    private JButton skip;

    /**
     * Main constructor.
     * @param controls Controls ({@link Controls Controls}) for game.
     */
    public SidePanel(Controls controls) {
        this.setDoubleBuffered(true);
        this.setLayout(layout);
        addLabel();
        addButton(controls);
    }

    /**
     * Method which sets text for JLabel.
     * @param text text to be set
     */
    public void setText(String text) {
        label.setText(text);
    }

    /**
     * Method to add and modify JLabel to panel.
     */
    private void addLabel() {
        c.gridwidth = 1;
        c.weightx = 0.1;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10,10,10,10);
        this.add(label, c);

    }

    /**
     * Method to add and modify JButton to panel.
     * @param controls
     */
    private void addButton(Controls controls) {
        skip = new JButton("Skip turn");
        skip.addMouseListener(controls);
        skip.setActionCommand("skip_turn");
        c.gridwidth = 1;
        c.weightx = 0.1;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10,10,10,10);
        this.add(skip, c);
    }
}
