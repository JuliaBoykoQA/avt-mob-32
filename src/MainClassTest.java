import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
        @Test
        public void testGetClassNumber()
        {
            int expected = 45;
            int actual = this.getClassNumber();

            Assert.assertTrue("Expected number <= 45 ", actual > expected);
        }
}
