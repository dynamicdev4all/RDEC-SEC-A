import javax.swing.JFrame;

public class AppFrame {
    private JFrame frame = new JFrame();

    AppFrame() {
        frame.setTitle("MCA APP 2");
        frame.setSize(600, 600);
        AppPanel gPanel = new AppPanel();
        frame.add(gPanel);
        frame.setVisible(true);
    }

}