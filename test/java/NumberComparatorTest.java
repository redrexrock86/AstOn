import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberComparatorTest {

    private final NumberComparator comparator = new NumberComparator();

    @Test
    public void greater() {
        Assert.assertEquals(comparator.compare(5, 3), "больше");
    }

    @Test
    public void smaller() {
        Assert.assertEquals(comparator.compare(3, 5), "меньше");
    }

    @Test
    public void equal() {
        Assert.assertEquals(comparator.compare(4, 4), "равны");
    }
}