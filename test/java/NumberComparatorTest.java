import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {
    private final NumberComparator comparator = new NumberComparator();

    @Test
    void greater() {
        assertEquals("больше", comparator.compare(5, 3));
    }

    @Test
    void smaller() {
        assertEquals("меньше", comparator.compare(3, 5));
    }

    @Test
    void equal() {
        assertEquals("равны", comparator.compare(4, 4));
    }
}