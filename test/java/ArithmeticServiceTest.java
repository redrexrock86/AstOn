import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticServiceTest {
    private final ArithmeticService service = new ArithmeticService();

    @Test
    void add() {
        assertEquals(5, service.add(2, 3));
    }

    @Test
    void subtract() {
        assertEquals(2, service.subtract(5, 3));
    }

    @Test
    void multiply() {
        assertEquals(20, service.multiply(4, 5));
    }

    @Test
    void divide() {
        assertEquals(5, service.divide(10, 2));
    }

    @Test
    void divideByZero() {
        assertThrows(ArithmeticException.class, () -> service.divide(10, 0));
    }
}