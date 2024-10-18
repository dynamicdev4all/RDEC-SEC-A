import java.util.Scanner;

public class SingleTon2 {
    public static void main(String[] args) {
        Car car1 = Car.createObj(4, 6, "Swift");
        System.out.println(car1.name);
        System.out.println(car1.noOfSeat);
        System.out.println(car1.wheelCount);
        System.out.println("*****************************");
        Car car2 = Car.createObj(4, 5, "Thar");
        System.out.println(car2.name);
        System.out.println(car2.noOfSeat);
        System.out.println(car2.wheelCount);
    }
}

class Car {
    static Car obj;
    int wheelCount;
    String name;
    int noOfSeat;

    private Car(int wheelCoun, int noOfSeat, String name) {
        wheelCount = wheelCoun;
        this.noOfSeat = noOfSeat;
        this.name = name;
    }

    static Car createObj(int wheelCount, int noOfSeat, String name) {
        if (obj == null) {
            obj = new Car(wheelCount, noOfSeat, name);
        }
        return obj;
    }
}
