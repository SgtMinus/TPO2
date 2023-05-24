package trigonometric;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CotTest {
    private Cot cot;

    @BeforeEach
    void init(){
        cot = new Cot();
    }

    @Test
    void zeroSin(){
        double result = cot.cot(-Math.PI, 0.01);
        assertEquals(Double.NaN, result);
    }

    @Test
    void correctResult(){
        double result = cot.cot(Math.PI/2, 0.01);
        assertEquals(0, result, 0.01);

        result = cot.cot(Math.PI/6, 0.01);
        assertEquals(1/Math.tan(Math.PI/6), result, 0.01);

        result = cot.cot(-Math.PI/6, 0.01);
        assertEquals(1/Math.tan(-Math.PI/6), result, 0.01);

        result = cot.cot(-14 * Math.PI/6, 0.01);
        assertEquals(1/Math.tan(-14 * Math.PI/6), result, 0.01);
    }
}