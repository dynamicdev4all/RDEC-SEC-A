import java.util.Scanner;

public class SingleTon {
    public static void main(String[] args) {
        Car car1 = new Car(  4, 6, "Swift");
        System.out.println(car1.name);
        System.out.println(car1.noOfSeat);
        System.out.println(car1.wheelCount);
        System.out.println("*****************************");
        Car car2 = new Car(4, 5, "Thar");
        System.out.println(car2.name);
        System.out.println(car2.noOfSeat);
        System.out.println(car2.wheelCount);
    }
}

class Car {
    int wheelCount;
    String name;
    int noOfSeat;

    Car(int wheelCoun, int noOfSeat, String name) {
        wheelCount = wheelCoun;
        this.noOfSeat = noOfSeat;
        this.name = name;
    }
}
