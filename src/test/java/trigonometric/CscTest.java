package trigonometric;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CscTest {
    private Csc csc;

    @BeforeEach
    void init(){
        csc = new Csc();
    }

    @Test
    void zeroSin(){
        double result = csc.csc(Math.PI, 0.01);
        assertEquals(Double.NaN, result);
    }

    @Test
    void correctResult(){
        double result = csc.csc(Math.PI/2, 0.01);
        assertEquals(1/Math.sin(Math.PI/2), result, 0.01);

        result = csc.csc(Math.PI/6, 0.01);
        assertEquals(1/Math.sin(Math.PI/6), result, 0.01);

        result = csc.csc(-Math.PI/6, 0.01);
        assertEquals(1/Math.sin(-Math.PI/6), result, 0.01);

        result = csc.csc(-14 * Math.PI/6, 0.01);
        assertEquals(1/Math.sin(-14 * Math.PI/6), result, 0.01);
    }

}