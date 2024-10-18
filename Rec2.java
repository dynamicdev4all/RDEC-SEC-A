public class Rec2 {

    // base case
    // small problem
    // inc /dec
    // call stack
    // static void printName(int c) {
    // if (c < 100) {
    // System.out.println("JAVA");
    // printName(c + 1);
    // }
    // return;

    // }
    static void printName(int c) {
        if (c == 0) {
            return;
        }
        System.out.println("JAVA");
        printName(c - 1);

    }

    static void printDigit(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printDigit(n - 1);
    }

    public static void main(String[] args) {
        // for (int i = 0; i < 5; i++) {
        // System.out.println("JAVA");
        // }
        printName(100);
    }
}
