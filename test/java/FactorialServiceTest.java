import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialServiceTest {
    private final FactorialService service = new FactorialService();

    @Test
    void factorialZero() {
        assertEquals(1, service.factorial(0));
    }

    @Test
    void factorialFive() {
        assertEquals(120, service.factorial(5));
    }

    @Test
    void factorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> service.factorial(-1));
    }
}