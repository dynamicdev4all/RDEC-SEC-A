import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.*;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.*;
import javax.imageio.*;

public class AppSurface extends JPanel {
    BufferedImage bufferImage;
    Timer timer;
    int yaxis = 0;

    AppSurface() {
        setSize(500, 500);
        // setBackground(Color.CYAN);
        showBgImage();
        bGRepaint();
    }

    void showBgImage() {
        try {
            bufferImage = ImageIO.read(AppSurface.class.getResource("jump.gif"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("YES");
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.drawImage(bufferImage, 50, yaxis, 200, 200, null);
    }

    void bGRepaint() {
        timer = new Timer(50, (a) -> {
            if (yaxis > 500) {
                yaxis = 0;
            }
            yaxis += 5;

            repaint();
        });
        timer.start();
    }
}
