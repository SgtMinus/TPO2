package trigonometric;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Tan {
    private Cos cos;
    private Sin sin;
    public Tan(){
        cos = new Cos();
        sin = new Sin();
    }
    public double tan(double x, double precision)
    {
        precision/=10;
        double cosinus = cos.cos(x,precision);
        double sinus = sin.sin(x, precision);
        if (cosinus == 0){
            return Double.NaN;
        } else
        {
            return sinus/cosinus;
        }
    }

    public double tan(double x, double precision, Writer out)
    {
        double result = tan(x, precision);
        try(CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
            printer.printRecord(x,result);
        } catch (IOException e) {
            System.out.println("Guess unlucky");
        }
        return result;
    }
}
