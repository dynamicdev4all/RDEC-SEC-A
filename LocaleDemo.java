import java.util.*;
import java.text.*;

public class LocaleDemo {

    static void printTotal(Locale locale) {
        // NumberFormat nf = new NumberFormat();
        // Numbe rFormat nf = NumberFormat.getNumberInstance();
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        System.out.println(nf.format(45320));
    }

    static void printDate(Locale locale) {
        Date date = new Date();
        DateFormat dtf = DateFormat.getDateInstance(DateFormat.FULL, locale);
        System.out.println(dtf.format(date));
    }

    public static void main(String[] args) {
        Locale locale = new Locale("jp", "JP"); // 19 oe below
        Locale locale2 = Locale.of("jp", "JP"); // 19 oe below

        // 100,000.00
        // 1,00,000.00
        // System.out.println(Locale.getDefault());
        printTotal(locale);
        printDate(locale);
    }
}
