package cs.checkers.client;

import javax.swing.JOptionPane;

import cs.checkers.client.game.GameRunner;

/**
   main() class, creates a new GameRunner and runs it
 */
public class App {
    public static void main(String[] args) {
      GameRunner runner = new GameRunner();
      if (!runner.initialize("localhost", 4999)) {
        JOptionPane.showMessageDialog(null, "Initializing failed, exit");
        return;
      } else {
        runner.run();
      }
    }
}
