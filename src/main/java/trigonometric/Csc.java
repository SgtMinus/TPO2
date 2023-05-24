package trigonometric;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Csc {
    private Sin sin;
    public Csc(){
        sin = new Sin();
    }

    public double csc(double x, double precision)
    {
        precision/=10;
        double sinus = sin.sin(x, precision);
        if (sinus == 0)
        {
            return Double.NaN;
        } else
        {
            return 1/sinus;
        }
    }

    public double csc(double x, double precision, Writer out)
    {
        double result = csc(x, precision);
        try(CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
            printer.printRecord(x,result);
        } catch (IOException e) {
            System.out.println("Guess unlucky");
        }
        return result;
    }
}
