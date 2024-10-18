import java.util.*;

public class RbBundle {
    public static void main(String[] args) {
        ResourceBundle rb;
        Locale locale;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose your Language");
        System.out.println("Press 1 for English");
        System.out.println("Press 2 for Hindi");
        System.out.println("Press 3 for Japanese");

        int langChoice = sc.nextInt();

        if (langChoice == 1) {
            locale = new Locale("en", "US");
        }

        else if (langChoice == 2) {
            locale = new Locale("hi", "IN");
        }

        else if (langChoice == 3) {
            locale = new Locale("jp", "JP");
        }

        else {
            System.out.println("Invalid Choice, by default using Eng");
            locale = new Locale("en", "US");
        }
        rb = ResourceBundle.getBundle("ResourceBundle", locale);
        System.out.println(rb.getString("ASK_NAME"));
        // String name = sc.nextLine();
    }
}
