package logariphmic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LnTest {
    private Ln ln;
    @BeforeEach
    void init(){
        ln = new Ln();
    }


    @Test
    void xZero(){
        double result = ln.ln(0, 0.5);
        assertEquals(result, Double.NaN);
    }

    @Test
    void xNegative(){
        double result = ln.ln(-5, 0.5);
        assertEquals(result, Double.NaN);
    }

    @Test
    void precisionZero(){
        double result = ln.ln(12, 0);
        assertEquals(result,Double.NaN);
    }

    @Test
    void precisionNegative(){
        double result = ln.ln(12, -2);
        assertEquals(result, Double.NaN);
    }

    @Test
    void correctResult(){
        double result = ln.ln(1, 0.001);
        assertEquals(Math.log(1), result, 0.001);
        result = ln.ln(10, 0.00000001);
        assertEquals(Math.log(10), result, 0.00000001);
    }

}