package cs.checkers.client.game;

import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

/**
 * GameRunnerTest
 */
public class GameRunnerTest {
  @Test
  public void initializingGoesWrong() {
    GameRunner runner = new GameRunner();
    assertTrue(!runner.initialize("8.8.8", 4999));
  }

  // I will probably have to create a mock server in another thread
  // to do this test, I will do it later
  public void initializingGoesRight() {
  }
}
