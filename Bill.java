import java.util.*;
import java.text.*;

public class Bill {
    static String printTotal(Locale locale, double num) {
        // NumberFormat nf = new NumberFormat();
        // Numbe rFormat nf = NumberFormat.getNumberInstance();
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        return nf.format(num);
    }

    static String printDate(Locale locale) {
        Date date = new Date();
        DateFormat dtf = DateFormat.getDateInstance(DateFormat.FULL, locale);
        return dtf.format(date);
    }

    public static void main(String[] args) {
        Locale locale = new Locale("jp", "JP");
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your name");
        String name = sc.nextLine();
        System.out.println("Purchased Item name?");
        String itemName = sc.nextLine();
        System.out.println("Price?");
        double totalPaid = sc.nextDouble();
        System.out.println("Tax in %?");
        double taxPer = sc.nextDouble();

        double taxPaid = totalPaid * (taxPer / 100);
        double netPaid = totalPaid - taxPaid;

        System.out.println("*****************************");
        System.out.println("Welcome, " + name);
        System.out.println("You have bought " + itemName + " on " + printDate(locale));
        System.out.println("Total Paid " + printTotal(locale, totalPaid));
        System.out.println("Tax Paid " + printTotal(locale, taxPaid));
        System.out.println("Net Paid " + printTotal(locale, netPaid));
    }
}
