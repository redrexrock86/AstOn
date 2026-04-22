import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaServiceTest {
    private final TriangleAreaService service = new TriangleAreaService();

    @Test
    void areaRightTriangle() {
        assertEquals(6.0, service.area(3, 4, 5), 0.001);
    }

    @Test
    void invalidTriangle() {
        assertThrows(IllegalArgumentException.class, () -> service.area(1, 2, 5));
    }
}