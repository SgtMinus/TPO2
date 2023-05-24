import logariphmic.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import trigonometric.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FunctionTest {

    private Sin sin;
    private Cos cos;
    private Tan tan;
    private Cot cot;
    private Sec sec;
    private Csc csc;
    private Ln ln;
    private Log log;
    private Function function;


    //x>0 tests
    @Test
    public void FunctionWhenXIsGreaterThanZeroAllMockTest() {
        sin = Mockito.mock(Sin.class);
        cos = Mockito.mock(Cos.class);
        tan = Mockito.mock(Tan.class);
        cot = Mockito.mock(Cot.class);
        sec = Mockito.mock(Sec.class);
        csc = Mockito.mock(Csc.class);
        ln = Mockito.mock(Ln.class);
        log = Mockito.mock(Log.class);
        function = new Function(sin, cos, tan, cot, sec, csc, ln, log);
        double x = 6.5;
        double precision = 0.1;
        when(ln.ln(x, precision)).thenReturn(1.8718);
        when(log.log(x, 3, precision)).thenReturn(1.7038);
        when(log.log(x, 2, precision)).thenReturn(2.7004);
        when(log.log(x, 5, precision)).thenReturn(1.163);
        when(log.log(x, 10, precision)).thenReturn(0.8129);
        double actual = function.function(x, precision);
        assertEquals(-646.744, actual, 0.1);
    }

    @Test
    public void FunctionWhenXIsGreaterThanZeroLnMockTest() {
        sin = Mockito.mock(Sin.class);
        cos = Mockito.mock(Cos.class);
        tan = Mockito.mock(Tan.class);
        cot = Mockito.mock(Cot.class);
        sec = Mockito.mock(Sec.class);
        csc = Mockito.mock(Csc.class);
        ln = Mockito.mock(Ln.class);
        log = new Log();
        function = new Function(sin, cos, tan, cot, sec, csc, ln, log);
        double x = 2.44;
        double precision = 0.1;
        when(ln.ln(x, precision)).thenReturn(0.89199);
        double actual = function.function(x, precision);
        assertEquals(-0.530432, actual, 0.1);
    }

    @Test
    public void FunctionWhenXIsGreaterThanZeroTest() {
        sin = Mockito.mock(Sin.class);
        cos = Mockito.mock(Cos.class);
        tan = Mockito.mock(Tan.class);
        cot = Mockito.mock(Cot.class);
        sec = Mockito.mock(Sec.class);
        csc = Mockito.mock(Csc.class);
        ln = new Ln();
        log = new Log();
        function = new Function(sin, cos, tan, cot, sec, csc, ln, log);
        double x = 2.44;
        double precision = 0.1;
        double actual = function.function(x, precision);
        assertEquals(-0.530432, actual, 0.1);
        x = 24;
        precision = 0.1;
        actual = function.function(x, precision);
        assertEquals(-95273.81888, actual, 0.1);
    }
    //x<=0 tests
    @Test
    public void FunctionWhenXIsLessThanOrEqualToZeroAllMockTest() {
        sin = Mockito.mock(Sin.class);
        cos = Mockito.mock(Cos.class);
        tan = Mockito.mock(Tan.class);
        cot = Mockito.mock(Cot.class);
        sec = Mockito.mock(Sec.class);
        csc = Mockito.mock(Csc.class);
        ln = Mockito.mock(Ln.class);
        log = Mockito.mock(Log.class);
        function = new Function(sin, cos, tan, cot, sec, csc, ln, log);
        double x = -Math.PI/6;
        double precision = 0.1;
        when(cot.cot(x, precision)).thenReturn(-Math.sqrt(3));
        when(sec.sec(x, precision)).thenReturn(2/Math.sqrt(3));
        when(csc.csc(x, precision)).thenReturn(-2.0);
        when(cos.cos(x, precision)).thenReturn(Math.sqrt(3)/2);
        when(tan.tan(x, precision)).thenReturn(-Math.sqrt(3)/3);
        when(sin.sin(x, precision)).thenReturn(-0.5);
        double actual = function.function(x, precision);
        assertEquals(-0.176224, actual, 0.1);
    }

    @Test
    public void FunctionWhenXIsLessThanOrEqualToZeroСscTest() {
        sin = Mockito.mock(Sin.class);
        cos = Mockito.mock(Cos.class);
        tan = Mockito.mock(Tan.class);
        cot = Mockito.mock(Cot.class);
        sec = Mockito.mock(Sec.class);
        csc = new Csc();
        ln = Mockito.mock(Ln.class);
        log = Mockito.mock(Log.class);
        function = new Function(sin, cos, tan, cot, sec, csc, ln, log);
        double x = -Math.PI/6;
        double precision = 0.1;
        when(cot.cot(x, precision)).thenReturn(-Math.sqrt(3));
        when(sec.sec(x, precision)).thenReturn(2/Math.sqrt(3));
        when(cos.cos(x, precision)).thenReturn(Math.sqrt(3)/2);
        when(tan.tan(x, precision)).thenReturn(-Math.sqrt(3)/3);
        when(sin.sin(x, precision)).thenReturn(-0.5);
        double actual = function.function(x, precision);
        assertEquals(-0.176224, actual, 0.1);
    }

    @Test
    public void FunctionWhenXIsLessThanOrEqualToZeroSecTest() {
        sin = Mockito.mock(Sin.class);
        cos = Mockito.mock(Cos.class);
        tan = Mockito.mock(Tan.class);
        cot = Mockito.mock(Cot.class);
        sec = new Sec();
        csc = Mockito.mock(Csc.class);
        ln = Mockito.mock(Ln.class);
        log = Mockito.mock(Log.class);
        function = new Function(sin, cos, tan, cot, sec, csc, ln, log);
        double x = -Math.PI/6;
        double precision = 0.1;
        when(cot.cot(x, precision)).thenReturn(-Math.sqrt(3));
        when(cos.cos(x, precision)).thenReturn(Math.sqrt(3)/2);
        when(csc.csc(x, precision)).thenReturn(-2.0);
        when(tan.tan(x, precision)).thenReturn(-Math.sqrt(3)/3);
        when(sin.sin(x, precision)).thenReturn(-0.5);
        double actual = function.function(x, precision);
        assertEquals(-0.176224, actual, 0.1);
    }

    @Test
    public void FunctionWhenXIsLessThanOrEqualToZeroCotTest() {
        sin = Mockito.mock(Sin.class);
        cos = Mockito.mock(Cos.class);
        tan = Mockito.mock(Tan.class);
        cot = new Cot();
        sec = Mockito.mock(Sec.class);
        csc = Mockito.mock(Csc.class);
        ln = Mockito.mock(Ln.class);
        log = Mockito.mock(Log.class);
        function = new Function(sin, cos, tan, cot, sec, csc, ln, log);
        double x = -Math.PI/6;
        double precision = 0.1;
        when(sec.sec(x, precision)).thenReturn(2/Math.sqrt(3));
        when(cos.cos(x, precision)).thenReturn(Math.sqrt(3)/2);
        when(csc.csc(x, precision)).thenReturn(-2.0);
        when(tan.tan(x, precision)).thenReturn(-Math.sqrt(3)/3);
        when(sin.sin(x, precision)).thenReturn(-0.5);
        double actual = function.function(x, precision);
        assertEquals(-0.176224, actual, 0.1);
    }

    @Test
    public void FunctionWhenXIsLessThanOrEqualToZeroTanTest() {
        sin = Mockito.mock(Sin.class);
        cos = Mockito.mock(Cos.class);
        tan = new Tan();
        cot = Mockito.mock(Cot.class);
        sec = Mockito.mock(Sec.class);
        csc = Mockito.mock(Csc.class);
        ln = Mockito.mock(Ln.class);
        log = Mockito.mock(Log.class);
        function = new Function(sin, cos, tan, cot, sec, csc, ln, log);
        double x = -Math.PI/6;
        double precision = 0.1;
        when(cot.cot(x, precision)).thenReturn(-Math.sqrt(3));
        when(sec.sec(x, precision)).thenReturn(2/Math.sqrt(3));
        when(csc.csc(x, precision)).thenReturn(-2.0);
        when(cos.cos(x, precision)).thenReturn(Math.sqrt(3)/2);
        when(sin.sin(x, precision)).thenReturn(-0.5);
        double actual = function.function(x, precision);
        assertEquals(-0.176224, actual, 0.1);
    }

    @Test
    public void FunctionWhenXIsLessThanOrEqualToZeroHighModulesTest() {
        sin = Mockito.mock(Sin.class);
        cos = Mockito.mock(Cos.class);
        tan = new Tan();
        cot = new Cot();
        sec = new Sec();
        csc = new Csc();
        ln = Mockito.mock(Ln.class);
        log = Mockito.mock(Log.class);
        function = new Function(sin, cos, tan, cot, sec, csc, ln, log);
        double x = -24*Math.PI-Math.PI/3;
        double precision = 0.1;
        when(cos.cos(x, precision)).thenReturn(0.5);
        when(sin.sin(x, precision)).thenReturn(Math.sqrt(3)/2);
        double actual = function.function(x, precision);
        assertEquals(-0.000032481, actual, 0.1);
    }

    @Test
    public void FunctionWhenXIsLessThanOrEqualToZeroCosTest() {
        sin = Mockito.mock(Sin.class);
        cos = new Cos();
        tan = new Tan();
        cot = new Cot();
        sec = new Sec();
        csc = new Csc();
        ln = Mockito.mock(Ln.class);
        log = Mockito.mock(Log.class);
        function = new Function(sin, cos, tan, cot, sec, csc, ln, log);
        double x = -24*Math.PI-Math.PI/3;
        double precision = 0.1;
        when(sin.sin(x, precision)).thenReturn(Math.sqrt(3)/2);
        double actual = function.function(x, precision);
        assertEquals(-0.000032481, actual, 0.1);
    }

    @Test
    public void FunctionWhenXIsLessThanOrEqualToZeroTest() {
        sin = new Sin();
        cos = new Cos();
        tan = new Tan();
        cot = new Cot();
        sec = new Sec();
        csc = new Csc();
        ln = Mockito.mock(Ln.class);
        log = Mockito.mock(Log.class);
        function = new Function(sin, cos, tan, cot, sec, csc, ln, log);
        double x = -24*Math.PI-Math.PI/3;
        double precision = 0.1;
        double actual = function.function(x, precision);
        assertEquals(-0.000032481, actual, 0.1);
        x = -42;
        actual = function.function(x,precision);
        assertEquals(actual, -0.02142327, precision);
        x = -0.13*Math.PI;
        actual = function.function(x, precision);
        assertEquals(actual, -0.35982, precision);
        x = -667;
        actual = function.function(x,precision);
        assertEquals(actual,0.094128, precision);
        x = 0;
        actual = function.function(x,precision);
        assertEquals(actual,Double.NaN, precision);
    }
}