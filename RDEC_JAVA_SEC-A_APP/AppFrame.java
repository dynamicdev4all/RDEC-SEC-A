import javax.swing.JFrame;

public class AppFrame extends JFrame {
    AppFrame() {
        initFrame();
    }

    void initFrame() {
        setTitle("ABCD");
        setSize(500, 500);
        setResizable(false  );
        AppSurface surface = new AppSurface();
        add(surface);
        setVisible(true);
    }
}
