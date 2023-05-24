package trigonometric;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinTest {
    private Sin sin;

    @BeforeEach
    void init(){
        sin = new Sin();
    }

    @Test
    void zeroPrecision(){
        double result = sin.sin(0, 0);
        assertEquals(Double.NaN, result);
    }

    @Test
    void negativePrecision(){
        double result = sin.sin(0, -5);
        assertEquals(Double.NaN, result);
    }

    @Test
    void correctResult(){
        double result = sin.sin(0, 0.01);
        assertEquals(0, result, 0.01);

        result = sin.sin(Math.PI, 0.01);
        assertEquals(0, result, 0.01);

        result = sin.sin(Math.PI/2, 0.01);
        assertEquals(1, result, 0.01);

        result = sin.sin(Math.PI*1.5, 0.01);
        assertEquals(-1, result, 0.01);

        result = sin.sin(Math.PI/3, 0.01);
        assertEquals(Math.sqrt(3)/2, result, 0.01);

        result = sin.sin(Math.PI/3+144*Math.PI, 0.01);
        assertEquals(Math.sqrt(3)/2, result, 0.01);
    }

}