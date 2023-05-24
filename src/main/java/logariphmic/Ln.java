package logariphmic;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Ln {

    public double ln(double z, double precision)
    {
        if (precision <= 0 || z<=0) return Double.NaN;
        precision/=100000;
        if (z>4)
        {
            return 2*ln(Math.sqrt(z),precision);
        }

        double x =  (z-1)/(z+1);
        double previousResult = 2*x;
        double currentResult = 2 * (x + x*x*x/3);
        double pow = x * x * x * x * x;
        int i = 5;
        while (Math.abs(currentResult-previousResult) > precision)
        {
            previousResult = currentResult;
            currentResult+= 2 * pow/i;
            i+=2;
            pow*=x*x;
        }
        return currentResult;
    }

    public double ln(double x, double precision, Writer out)
    {
        double result = ln(x, precision);
        try(CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
            printer.printRecord(x,result);
        } catch (IOException e) {
            System.out.println("Guess unlucky");
        }
        return result;
    }
}
