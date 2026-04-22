import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticServiceTest {

    private final ArithmeticService service = new ArithmeticService();

    @Test
    public void add() {
        Assert.assertEquals(service.add(2, 3), 5);
    }

    @Test
    public void subtract() {
        Assert.assertEquals(service.subtract(5, 3), 2);
    }

    @Test
    public void multiply() {
        Assert.assertEquals(service.multiply(4, 5), 20);
    }

    @Test
    public void divide() {
        Assert.assertEquals(service.divide(10, 2), 5);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divideByZero() {
        service.divide(10, 0);
    }
}