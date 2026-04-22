import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleAreaServiceTest {

    private final TriangleAreaService service = new TriangleAreaService();

    @Test
    public void areaRightTriangle() {
        Assert.assertEquals(service.area(3, 4, 5), 6.0, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void invalidTriangle() {
        service.area(1, 2, 5);
    }
}