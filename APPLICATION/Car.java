import java.io.IOException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Car {
    int x;
    int y;
    int h;
    int w;
    int speed;
    String carName;
    BufferedImage carIamge;

    Car(String carName, int x, int y, int h, int w, int speed) {
        this.carName = carName;
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.speed = speed;
        loadCar();
    }

    void loadCar() {
        try {
            carIamge = ImageIO.read(Car.class.getResource(carName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("NO IMAGE FOUND");
            e.printStackTrace();
        }
    }

    void drawCar(Graphics brush) {
        brush.drawImage(carIamge, x, y, w, h, null);
    }
}
