import logariphmic.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import trigonometric.*;

import java.io.IOException;
import java.io.Writer;

public class Function {
    private Sin sin;
    private Cos cos;
    private Tan tan;
    private Cot cot;
    private Sec sec;
    private Csc csc;
    private Ln ln;
    private Log log;
    public Function(){
        sin = new Sin();
        cos = new Cos();
        tan = new Tan();
        cot = new Cot();
        sec = new Sec();
        csc = new Csc();
        ln = new Ln();
        log = new Log();
    }

    public Function(Sin sin, Cos cos, Tan tan, Cot cot, Sec sec, Csc csc, Ln ln, Log log) {
        this.sin = sin;
        this.cos = cos;
        this.tan = tan;
        this.cot = cot;
        this.sec = sec;
        this.csc = csc;
        this.ln = ln;
        this.log = log;
    }

    public  Double function(double x, double precision)
    {
        try {
            if (x<=0){
                return Math.pow((((cot.cot(x,precision)/ sec.sec(x,precision))  * csc.csc(x,precision)) - Math.pow(cos.cos(x,precision),3))/
                        (Math.pow(tan.tan(x,precision),3) - (csc.csc(x,precision)/sin.sin(x,precision))),3);
            } else
                return Math.pow(ln.ln(x,precision)* log.log(x,3,precision)*Math.pow(ln.ln(x,precision),2)*log.log(x,2,precision),2)/
                        (log.log(x,5,precision) - (log.log(x,10,precision)/log.log(x,5,precision)) - ln.ln(x,precision));
        } catch (Exception e) {
            return Double.NaN;
        }
    }


    public double function(double x, double precision, Writer out)
    {
        double result = function(x, precision);
        try(CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
            printer.printRecord(x,result);
        } catch (IOException e) {
            System.out.println("Guess unlucky");
        }
        return result;
    }
}
