package cs.checkers.common;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * CommandParserTest
 */
public class CommandParserTest {

  @Test
  public void testValidCommand() {
    String command = "move 0,0 1,1";
    CommandParser parser = new CommandParser();
    assertTrue(parser.parse(command));
    assertTrue(parser.getX1() == 0);
    assertTrue(parser.getY1() == 0);
    assertTrue(parser.getX2() == 1);
    assertTrue(parser.getY2() == 1);
  }

  @Test
  public void testInvalidCommand() {
    String command = "xd";
    CommandParser parser = new CommandParser();
    assertFalse(parser.parse(command));
  }
}
