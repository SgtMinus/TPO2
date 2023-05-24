package logariphmic;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Log {
    private Ln ln;
    public Log(){
        ln = new Ln();
    }
    public double log(double x, double base, double precision)
    {
        precision/=10;
        if (base == 1)
        {
            return Double.NaN;
        }
        return ln.ln(x, precision)/ln.ln(base,precision);
    }


    public double log(double x, double base, double precision, Writer out)
    {
        double result = log(x, base, precision);
        try(CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
            printer.printRecord(x, base, result);
        } catch (IOException e) {
            System.out.println("Guess unlucky");
        }
        return result;
    }


}
