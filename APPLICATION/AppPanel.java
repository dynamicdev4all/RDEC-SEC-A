import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class AppPanel extends JPanel {

    static BufferedImage bufferImage;
    Timer timer;
    int xAxis = 0;
    int yAxis = 0;
    Car car1;
    Car car2;
    AppPanel() {
        setSize(500, 500);
        // setBackground(Color.CYAN);
        car1 = new Car("car.png",100, 100, 120, 80, 5);
        // car2 = new Car("car2.png",250, 300, 120, 80, 5);
        showBgImage();
        recallPaintComp();
        keyboardOpr();
        setFocusable(true);
    }

    static void showBgImage() {
        try {
            bufferImage = ImageIO.read(AppPanel.class.getResource("road.jpeg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("NO IMAGE FOUND");
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.drawImage(bufferImage, xAxis, yAxis, 500, 50, null);
        car1.drawCar(g);
        // car2.drawCar(g);
    }

    void recallPaintComp() {
        timer = new Timer(30, (abcd) -> {
            // if (xAxis < 500) {
            // xAxis += 5;
            // yAxis += 7;
            // } else {
            // xAxis = 0;
            // yAxis = 0;
            // }
            repaint();
        });
        timer.start();
    }

    void keyboardOpr() {
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    xAxis += 5;
                }
             
                throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
            }

        });
    }
}
