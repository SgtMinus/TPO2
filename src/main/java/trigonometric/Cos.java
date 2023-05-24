package trigonometric;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Cos {
    Sin sin;
    public Cos() {
        sin = new Sin();
    }
    public Double cos(double x, double precision)
    {
        if (precision<=0 || x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY)
        {
            return Double.NaN;
        }
        double PI2 = Math.PI * 2;
        if (x >= 0) {
            while (x > PI2)
            {
                x -= PI2;
            }
        } else if (x < 0){
            while (x < 0)
            {
                x += PI2;
            }
        }
        precision/=100;
        double result = Math.sqrt(1-Math.pow(sin.sin(x,precision),2));
        if (x<=3*Math.PI/2 && x>=Math.PI/2)
        {
            result = -result;
        }


        return result;


    }

    public double cos(double x, double precision, Writer out)
    {
        double result = cos(x, precision);
        try(CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
            printer.printRecord(x,result);
        } catch (IOException e) {
            System.out.println("Guess unlucky");
        }
        return result;
    }
}
