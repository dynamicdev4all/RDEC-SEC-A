import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Input{
    public static void main(String[] args) throws FileNotFoundException{
        // PrintStream out= new PrintStream(null)
        // System.setOut(new PrintStream("C:\\Users\\ACER\\Documents\\RDEC_JAVA_A\\temp.txt"));
        PrintStream abcd = new PrintStream("C:\\Users\\ACER\\Documents\\RDEC_JAVA_A\\temp2.exe");
        abcd.println("Deepak is a Student");
    }
}
