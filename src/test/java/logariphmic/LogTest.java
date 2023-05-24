package logariphmic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogTest {
    private Log log;
    @BeforeEach
    void init(){
        log = new Log();
    }


    @Test
    void xZero(){
        double result = log.log(0, 5, 0.5);
        assertEquals(result, Double.NaN);
    }

    @Test
    void xNegative(){
        double result = log.log(-5, 5, 0.5);
        assertEquals(result, Double.NaN);
    }

    @Test
    void baseZero(){
        double result = log.log(5, 0, 0.5);
        assertEquals(result, Double.NaN);
    }

    @Test
    void baseNegative(){
        double result = log.log(5, -5, 0.5);
        assertEquals(result, Double.NaN);
    }

    @Test
    void baseOne(){
        double result = log.log(5, 1, 0.5);
        assertEquals(result, Double.NaN);
    }

    @Test
    void precisionZero(){
        double result = log.log(5, 5, 0);
        assertEquals(result,Double.NaN);
    }

    @Test
    void precisionNegative(){
        double result = log.log(5, 5, -0.1);
        assertEquals(result, Double.NaN);
    }

    @Test
    void correctResult(){
        double result = log.log(1, 5, 0.001);
        assertEquals(0, result, 0.001);
        result = log.log(27, 3, 0.00000001);
        assertEquals(3, result, 0.00000001);
    }
}