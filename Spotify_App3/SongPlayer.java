import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SongPlayer {

    SongPlayer() {
        Platform.startup(() -> {
        });
    }

    static void playPauseSong() {
        new SongPlayer();
        Platform.runLater(() -> {
            String songUrl = "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview115/v4/16/63/2c/16632cd6-b022-96e9-2fa5-3b209fd568b6/mzaf_10747445059300180724.plus.aac.p.m4a";
            Media media = new Media(songUrl);
            MediaPlayer player = new MediaPlayer(media);

            player.play(); // this will play the song

            // player.pause();// this will pause the song
        });
    }

    public static void main(String[] args) {
        playPauseSong();
    }
}
