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
    assertTrue(!runner.initialize("xd", 1));
  }

}
