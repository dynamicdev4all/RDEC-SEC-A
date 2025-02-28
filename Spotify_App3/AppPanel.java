import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AppPanel extends JPanel {
    Timer timer;

    BufferedImage songImage;

    JButton playPauseButton;
    JButton nextSongButton;
    JButton previousSongButton;

    int currentSongInedx = 0;

    ArrayList<SongModel> songList = ApiClient.getSongList();

    AppPanel() {
        setSize(600, 600);
        setBackground(Color.PINK);

        playPauseButton = new JButton("Play/Pause");
        nextSongButton = new JButton("Next");
        previousSongButton = new JButton("Previous");
        add(playPauseButton);
        add(nextSongButton);
        add(previousSongButton);
        loadSongImage();
        addButtonControls();
        appLoop();
        // loadBgImage();
        setFocusable(true);
    }

    void addButtonControls() {
        nextSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSongInedx++;
                loadSongImage();
                System.out.println(currentSongInedx);
            }
        });
        previousSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSongInedx--;
                loadSongImage();
                System.out.println(currentSongInedx);
            }
        });
    }

    void loadSongImage() {
        System.out.println("Load Image is called");
        try {
            songImage = ImageIO.read(new URL(songList.get(currentSongInedx).songImageUrl));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void appLoop() {
        timer = new Timer(80, (abc) -> {
            // loadSongImage();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        pen.setFont(new Font("arial", Font.BOLD, 30));
        pen.drawString(songList.get(currentSongInedx).songName, 150, 410);
        pen.drawString(songList.get(currentSongInedx).singerName, 200, 450);
        pen.drawImage(songImage, 175, 125, 250, 250, null);
    }
}
