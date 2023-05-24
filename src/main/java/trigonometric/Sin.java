package trigonometric;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;


public class Sin {
    public Double sin(double x, double precision)
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

        if (x==0||x==Math.PI) return 0.0;
        if (x==Math.PI/2) return 1.0;
        precision/=10;
        double currentResult = x-x*x*x/6;
        double previousResult = x;
        double powDivFact = (x*x*x*x*x)/120;
        int i = 3;
        int sign = 1;

        while (Math.abs(currentResult-previousResult) > precision){
            previousResult = currentResult;
            currentResult = previousResult + sign *powDivFact;
            powDivFact *= x*x/(2*i*(2*i+1));
            sign = -sign;
            i += 1;
        }

        if (Math.abs(currentResult)>1){
            currentResult = (currentResult<-1)? -1:1;
        }
        return currentResult;

    }

    public double sin(double x, double precision, Writer out)
    {
        double result = sin(x, precision);
        try(CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
            printer.printRecord(x,result);
        } catch (IOException e) {
            System.out.println("Guess unlucky1");
        }
        return result;
    }

}
