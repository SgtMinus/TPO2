package trigonometric;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Sec {
    private Cos cos;
    public Sec(){
        cos = new Cos();
    }
    public double sec(double x, double precision)
    {
        precision/=10;
        double cosinus = cos.cos(x, precision);
        if (cosinus == 0)
        {
            return Double.NaN;
        } else
        {
            return 1/cosinus;
        }
    }


    public double sec(double x, double precision, Writer out)
    {
        double result = sec(x, precision);
        try(CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
            printer.printRecord(x,result);
        } catch (IOException e) {
            System.out.println("Guess unlucky");
        }
        return result;
    }
}
