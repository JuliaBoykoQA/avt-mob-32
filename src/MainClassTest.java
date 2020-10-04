import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
        @Test
        public void testGetClassString()
        {
            String expected1 = "Hello";
            String expected2 = "hello";

            String actual = getClassString();

            Assert.assertTrue("The expected result does not contain Hello or hello.",
                    actual.contains(expected1) || actual.contains(expected2));
        }
}
