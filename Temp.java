import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
        // String name = " Keshav is a CSE student ";
        // name = name.trim();
        // int c = 0;
        // for (int i = 0; i < name.length(); i++) {
        // if (name.charAt(i) == ' ' && name.charAt(i+1)!= ' ') {
        // c++;
        // }
        // }
        // System.out.println(c+1);

        Scanner sc = new Scanner("Keshav is a CSE student");

        int c = 0;
        while (sc.hasNext()) {
            // sc.next();
            c++;
        }
        System.out.println(c);
    }
}
