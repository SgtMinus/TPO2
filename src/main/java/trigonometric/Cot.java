package trigonometric;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Cot {

    private Cos cos;
    private Sin sin;

    public Cot(){
        cos = new Cos();
        sin = new Sin();
    }
    public double cot(double x, double precision)
    {
        precision/=10;
        double cosinus = cos.cos(x, precision);
        double sinus = sin.sin(x, precision);
        if (sinus == 0){
            return Double.NaN;
        } else
        {
            return cosinus/sinus;
        }
    }


    public double cot(double x, double precision, Writer out)
    {
        double result = cot(x, precision);
        try(CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
            printer.printRecord(x,result);
        } catch (IOException e) {
            System.out.println("Guess unlucky");
        }
        return result;
    }
}
