package trigonometric;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TanTest {
    private Tan tan;

    @BeforeEach
    void init(){
        tan = new Tan();
    }

    @Test
    void zeroCos(){
        double result = tan.tan(Math.PI/2, 0.01);
        assertEquals(Double.NaN, result);
    }

    @Test
    void correctResult(){
        double result = tan.tan(0, 0.01);
        assertEquals(0, result, 0.01);

        result = tan.tan(Math.PI/6, 0.01);
        assertEquals(Math.tan(Math.PI/6), result, 0.01);

        result = tan.tan(Math.PI, 0.01);
        assertEquals(Math.tan(Math.PI), result, 0.01);

        result = tan.tan(2 * Math.PI, 0.01);
        assertEquals(Math.tan(2 * Math.PI), result, 0.01);

        result = tan.tan(-Math.PI/6, 0.01);
        assertEquals(Math.tan(-Math.PI/6), result, 0.01);

        result = tan.tan(-14 * Math.PI/6, 0.01);
        assertEquals(Math.tan(-14 * Math.PI/6), result, 0.01);

        result = tan.tan(-2 * Math.PI, 0.01);
        assertEquals(Math.tan(-2 * Math.PI), result, 0.01);
    }

}