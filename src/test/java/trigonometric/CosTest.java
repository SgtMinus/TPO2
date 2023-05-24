package trigonometric;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CosTest {
    private Cos cos;

    @BeforeEach
    void init(){
        cos = new Cos();
    }

    @Test
    void zeroPrecision(){
        double result = cos.cos(0, 0);
        assertEquals(Double.NaN, result);
    }

    @Test
    void negativePrecision(){
        double result = cos.cos(0, -5);
        assertEquals(Double.NaN, result);
    }

    @Test
    void correctResult(){
        double result = cos.cos(0, 0.01);
        assertEquals(1, result, 0.01);

        result = cos.cos(Math.PI, 0.01);
        assertEquals(-1, result, 0.01);

        result = cos.cos(Math.PI/2, 0.01);
        assertEquals(0, result, 0.01);

        result = cos.cos(Math.PI*1.5, 0.01);
        assertEquals(0, result, 0.01);

        result = cos.cos(Math.PI/6, 0.01);
        assertEquals(Math.sqrt(3)/2, result, 0.01);

        result = cos.cos(Math.PI/6+144*Math.PI, 0.01);
        assertEquals(Math.sqrt(3)/2, result, 0.01);
    }

    @ParameterizedTest(name = "cos({0})")
    @DisplayName("Check Default Table dots")
    @ValueSource(doubles = {-2*Math.PI, -Math.PI, -Math.PI*0.5, 0, 0.5*Math.PI, Math.PI, 2*Math.PI})
    void checkDefaultValues(double param)
    {
        assertAll(
                () -> assertEquals(Math.cos(param), cos.cos(param, 0.0001), 0.01));
    }

}