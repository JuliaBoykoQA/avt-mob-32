import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
        @Test
        public void testGetLocalNumber()
        {
            int number = this.getLocalNumber();
            int expected = 14;

            Assert.assertTrue("Expected number != 14", number == expected);
        }
}
