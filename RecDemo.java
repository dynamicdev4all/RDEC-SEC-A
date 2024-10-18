public class RecDemo {

    // void without parameter
    static void sum0() {
        System.out.println("This is fn 0");
        sum1(0);
    }

    // void with parameter
    static void sum1(int a) {
        System.out.println("This is fn 1");
        sum2();
    }

    // non-void without parameter
    static int sum2() {
        System.out.println("This is fn 2");
        sum3(0);
        return 0;
    }

    // non-void with parameter
    static int sum3(int a) {
        System.out.println("This is fn 3");
        return 0;
    }

    public static void main(String[] args) {
        sum0();
    }
}
