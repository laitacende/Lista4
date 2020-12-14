import cs.checkers.gamelogic.checker.Checker;
import cs.checkers.gamelogic.checker.ManagerChecker;
import cs.checkers.gamelogic.field.Field;
import cs.checkers.gamelogic.field.PlainField;
import cs.checkers.gamelogic.field.UnavailableField;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FieldTest {
   Field field;
   Checker checker;

   @Before
   public void setUp() {
       ManagerChecker managerChecker = new ManagerChecker();
       checker = managerChecker.buildChecker("chinese basic");
   }

   @Test
    public void testPlainField() {
       field = new PlainField();
      // field doesn't have checker
       assertEquals(null, field.getChecker());
       // put checker in field
       field.putChecker(checker);
       assertEquals(checker, field.getChecker());

       // take checker from field
       field.takeChecker();
       assertEquals(null, field.getChecker());
   }

   @Test
   public void unavailableField() {
      field = new UnavailableField();

      // test if it is possible to place a checker
      field.putChecker(checker);
      assertEquals(null, field.getChecker());
      assertEquals(null, field.getChecker());

      field.takeChecker();
      // still null
      assertEquals(null, field.getChecker());
   }
}
