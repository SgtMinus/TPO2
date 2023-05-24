package trigonometric;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecTest {
    private Sec sec;

    @BeforeEach
    void init(){
        sec = new Sec();
    }

    @Test
    void zeroCos(){
        double result = sec.sec(Math.PI/2, 0.01);
        assertEquals(Double.NaN, result);
    }

    @Test
    void correctResult(){
        double result = sec.sec(0, 0.01);
        assertEquals(1/Math.cos(0), result, 0.01);

        result = sec.sec(Math.PI/6, 0.01);
        assertEquals(1/Math.cos(Math.PI/6), result, 0.01);

        result = sec.sec(Math.PI, 0.01);
        assertEquals(1/Math.cos(Math.PI), result, 0.01);

        result = sec.sec(2 * Math.PI, 0.01);
        assertEquals(1/Math.cos(2 * Math.PI), result, 0.01);

        result = sec.sec(-Math.PI/6, 0.01);
        assertEquals(1/Math.cos(-Math.PI/6), result, 0.01);

        result = sec.sec(-14 * Math.PI/6, 0.01);
        assertEquals(1/Math.cos(-14 * Math.PI/6), result, 0.01);

        result = sec.sec(-2 * Math.PI, 0.01);
        assertEquals(1/Math.cos(-2 * Math.PI), result, 0.01);
    }

}