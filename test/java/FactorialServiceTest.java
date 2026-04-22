import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialServiceTest {

    private final FactorialService service = new FactorialService();

    @Test
    public void factorialZero() {
        Assert.assertEquals(service.factorial(0), 1);
    }

    @Test
    public void factorialFive() {
        Assert.assertEquals(service.factorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void factorialNegative() {
        service.factorial(-1);
    }
}